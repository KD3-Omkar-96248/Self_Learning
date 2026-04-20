enum Day 
{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() 
    {
        return this == SATURDAY || this == SUNDAY;
    }

    public String getDayType() 
    {
        return isWeekend() ? "Weekend" : "Weekday";
    }
}