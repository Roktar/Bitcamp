package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

public class TaskDao {
        Task[] tasks = new Task[1000];
        int taskIndex = 0;
    
        public void insert(Task task) {
            task.setTaskNo(taskIndex);
            this.tasks[this.taskIndex++] = task;
        }
        
        public Task[] list() {
            Task[] arr = new Task[taskIndex];
            for (int i = 0; i < taskIndex; i++) 
                arr[i] = tasks[i];
            return arr;
        }
        
        /*public Task get(String name) {
            int i = this.getTaskIndex(name);
            
            if(i != -1)
                return tasks[i];
            else
                return null;
        }

        public void update(Team team) {
            int i = this.getTaskIndex(team.getName());
            
            if( i != -1)
                teams[i] = team;
        }
        
        public void delete(String name) {
            int i = this.getTeamIndex(name);
            
            if( i != -1)
                teams[i] = null;
        }
        
        private int getTeamIndex(String name) {
            for(int i=0; i<teams.length; i++) {
                if(teams[i].getName().equals(name.toLowerCase())) {
                   return i;
                }
            }
            return -1;
        }
    }*/

}
