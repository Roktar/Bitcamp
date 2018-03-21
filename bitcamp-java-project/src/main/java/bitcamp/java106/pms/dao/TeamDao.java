package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    int currentIndex = -1;
    
    public void insert(Team team) {
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[teamIndex];
        for (int i = 0; i < teamIndex; i++) 
            arr[i] = teams[i];
        return arr;
    }
    
    public Team get(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (teams[i].name.equals(name.toLowerCase())) {
                currentIndex = i;
                System.out.println("반환 : " + teams[i].name);
                return teams[i];
            }
        }
        return null;
    }
    
    public void update(Team team) {
        teams[currentIndex] = team;
        int currentIndex = -1;
    }
    
    public void delete() {
        teams[currentIndex] = null;
        int currentIndex = -1;
    }
}
