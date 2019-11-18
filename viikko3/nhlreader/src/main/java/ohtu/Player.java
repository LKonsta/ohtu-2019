
package ohtu;

public class Player {
    private Integer goals;
    private Integer assists;
    private String name;
    private Integer penalties;
    private String team;
    private String nationality;
    private String birthdate;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
//        return name + " team " + team + " goals " + goals + " assists " + assists;
        Integer yhes = goals+assists;
        return 
                padRight(name, 20) + 
                padRight(nationality, 5) +
                padRight(goals.toString(), 2) + "+ " + 
                padRight(assists.toString(), 3) + "=" +
                padLeft(yhes.toString(), 3)
                ;
    
    
    }
    
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}
