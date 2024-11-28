INCLUDE Irvine32.inc

.data
; student data hardcoded
; 1 byte grade + 8 byte name = 9 byte entry
student_data BYTE   55, "Bob     ",
                    45, "Tom     ",
                    62, "Rob     ",
                    78, "Amy     ",
                    90, "Filbert ",
                    95, "Jacques ",
                    60, "Matilda ",
                    33, "Johnson ",
                    12, "Rick    ",
                    34, "Alice   ",

; constants: 10 for number of students, 9 for entry size (each row), and a space string used for printing student data
NUM_STUDENTS = 10
ENTRY_SIZE = 9   
SPACE_STR BYTE " ", 0
; used to hold the count of each grade; A, B, C, D, F
grade_count BYTE 0, 0, 0, 0, 0 

.code
main PROC
    ; initialize student counter and offset for data
    mov esi, 0
    mov ebx, 0

; count grades for each student in data
count_grades:
    ; load byte from data at position ebx into eax (student grade)
    movzx eax, byte ptr student_data[ebx]
    
    ; compare grades to numerical values and jump to the corresponding letter grade
    cmp eax, 90
    jge is_A
    cmp eax, 80
    jge is_B
    cmp eax, 70
    jge is_C
    cmp eax, 60
    jge is_D
    jmp is_F

; increment the grade_count array at the correct index and jump to continue_count
is_A:
    inc grade_count[0]
    jmp continue_count
is_B:
    inc grade_count[1]
    jmp continue_count
is_C:
    inc grade_count[2]
    jmp continue_count
is_D:
    inc grade_count[3]
    jmp continue_count
is_F:
    inc grade_count[4]

continue_count:
    ; move to the next student's grade
    add ebx, ENTRY_SIZE
    ; increment student counter
    inc esi
    ; check if all students have been counted
    cmp esi, NUM_STUDENTS
    ; if not all students are counted, jump back to count_grades
    jl count_grades

    ; move each grade count into eax and print it
    movzx eax, grade_count[0]
    call WriteDec
    movzx eax, grade_count[1]
    call WriteDec
    movzx eax, grade_count[2]
    call WriteDec
    movzx eax, grade_count[3]
    call WriteDec
    movzx eax, grade_count[4]
    call WriteDec
    ; once all grade counts are printed, go to the next line
    call Crlf

    ; reset counter for sorting
    mov esi, 0

; outer loop
L1:
    ; if counter is >= number of students - 1, print results
    ; this is because the last student will be sorted by the end, so there is no need to check it
    ; for(int i = 0; i < num_students - 1; i++)
    cmp esi, NUM_STUDENTS - 1
    jge print_results
    ; initial maximum grade index is the current student
    mov edi, esi
    mov ebx, esi
    ; increment the inner loop for the next student
    inc ebx

; inner loop
L2:
    ; if counter >= number of students, swap
    ; for(int j = i + 1; j < num_students; j++)
    cmp ebx, NUM_STUDENTS
    jge swap_entry
    ; load current maximum index
    mov eax, edi
    ; find offset of current maximum
    mov cl, ENTRY_SIZE
    mul cl
    ; store offset of current maximum
    mov ecx, eax
    ; load current index
    mov eax, ebx
    ; find offset of current entry
    mov dl, ENTRY_SIZE
    mul dl
    ; store offset of current entry
    mov edx, eax
    ; load grade of current student and compare with current maximum grade
    mov al, byte ptr student_data[edx]
    cmp al, byte ptr student_data[ecx]
    ; if current grade <= maximum grade, skip to next student
    jle continue_L2
    ; update maximum index if a larger grade is found
    mov edi, ebx

continue_L2:
    ; increment L2 index, and jump to L2
    inc ebx
    jmp L2

; prepare the swap of two entries
swap_entry:
    ; check if maximum is at the current position
    ; if it is, jump to L1
    cmp edi, esi
    je continue_L1
    ; load current index
    mov eax, esi
    ; find and store offset of current index
    mov cl, ENTRY_SIZE
    mul cl
    mov ecx, eax
    ; load maximum index
    mov eax, edi
    ; find and store offset of maximum index
    mov dl, ENTRY_SIZE
    mul dl
    mov edx, eax
    ; set counter for swap
    mov ebx, 0

; swap all bytes of two entries
swap_byte:
    ; load byte from current entry and from maximum entry
    mov al, student_data[ecx + ebx]
    mov ah, student_data[edx + ebx]
    ; swap bytes
    mov student_data[ecx + ebx], ah
    mov student_data[edx + ebx], al
    ; increment counter
    inc ebx
    ; continue until the full entry is swapped
    cmp ebx, ENTRY_SIZE
    jl swap_byte

continue_L1:
    ; after complete swap, increment L1 index and jump to L1
    inc esi
    jmp L1

print_results:
    ; prepare printing by reseting student counter and offset
    mov esi, 0
    mov ebx, 0

print_loop:
    ; load and print the student grade
    movzx eax, byte ptr student_data[ebx]
    call WriteDec
    ; load and print the space string
    mov edx, offset SPACE_STR
    call WriteString
    ; set counter for printing name
    mov ecx, ENTRY_SIZE - 2
    ; move to the start of the name
    add ebx, 1

print_name:
    ; load and print the current character in the name
    movzx eax, byte ptr student_data[ebx]
    call WriteChar
    ; move to next character and repeat printing
    inc ebx
    loop print_name
    ; move to next entry and new line
    inc ebx
    call Crlf
    ; increment student counter
    inc esi
    ; if not all students have been printed, continue printing
    cmp esi, NUM_STUDENTS
    jl print_loop

main ENDP
END main