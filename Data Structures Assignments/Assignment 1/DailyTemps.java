

public class DailyTemps {
    // private int array of size 7 (one for each day of the week) to hold the daily temperatures
    private int[] temps = new int[7];

    // constructor takes in an array of temperatures and stores the values in the object's temps array
    public DailyTemps(int[] temps){
        this.temps = temps;
    }

    // takes in an index corresponding to a day in the temps array (0-6) and sets the temperature at that index to newTemp
    // if the index is outside the bounds of the array [0,6], then the method throws an out of bounds exception which is caught in TestTemps
    public void setTemp(int dayIndex, int newTemp) throws ArrayIndexOutOfBoundsException{
        if(dayIndex >= 0 && dayIndex <= 6){
            temps[dayIndex] = newTemp;
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
            
    }

    // iterates through the array of temps and returns the number of days in which the temperature is below 32F (freezing)
    public int freezing(){
        int count = 0;
        for(int temp : temps){
            if(temp < 32){
                count++;
            }
        }
        return count;
    }

    // iterates through the array of temps and returns the name of the day with the highest temperature
    public String warmest(){
        int warmestDayIndex = 0;
        int warmestDayTemp = temps[0];
        String warmestDay = "";
        // iterates through the array of temps and finds the index of the highest temp
        for(int i = 1; i < temps.length; i++){
            if(temps[i] > warmestDayTemp){
                warmestDayTemp = temps[i];
                warmestDayIndex = i;
            }
        }

        // takes the index of the highest temperature day and sets warmestDay to the name of the day corresponding to that index
        switch(warmestDayIndex){
            case 0: 
                warmestDay = "Monday";
                break;
            case 1:
                warmestDay = "Tuesday";
                break;
            case 2:
                warmestDay = "Wednesday";
                break;
            case 3:
                warmestDay = "Thursday";
                break;
            case 4:
                warmestDay = "Friday";
                break;
            case 5:
                warmestDay = "Saturday";
                break;
            case 6:
                warmestDay = "Sunday";
                break;
        }
        return warmestDay;
    }

    // returns a string of all days of the week and their corresponding temperatures each in a new line
    public String printTemps(){
        String tempsString = "";
        tempsString += "Monday       " + temps[0];
        tempsString += "\nTuesday      " + temps[1];
        tempsString += "\nWednesday    " + temps[2];
        tempsString += "\nThursday     " + temps[3];
        tempsString += "\nFriday       " + temps[4];
        tempsString += "\nSaturday     " + temps[5];
        tempsString += "\nSunday       " + temps[6];
        return tempsString;
    }
}
