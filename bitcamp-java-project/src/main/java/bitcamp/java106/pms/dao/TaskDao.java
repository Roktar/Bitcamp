package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        
        int count = 0;
        
<<<<<<< HEAD
        for (int i = 0; i < taskIndex; i++) { 
                if(tasks[i] == null) continue;
                
                if(tasks[i].getTeam().getName().equals(teamName))
                    arr[count++] = tasks[i];
        }
        
        return arr;
    }
    
    public int count(String teamName) {
        int cnt = 0;
        
        for(int i=0; i<taskIndex; i++) {
            if(tasks[i].getTeam().getName().equals(teamName))
                cnt++;
=======
        public Task get(int taskNo) {
            int i = this.getTaskIndex(taskNo);
            
            if(i != -1)
                return tasks[i];
            else
                return null;
        }
        
        public void update(Task task) {
            int i = this.getTaskIndex(task.getTaskNo());
            
            if( i != -1)
                tasks[i] = task;
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
        }
        return cnt;
    }
    
    public Task get(String teamName, int taskNo) {
        
<<<<<<< HEAD
        for (int i = 0; i < taskIndex; i++) { 
            if(tasks[i] == null) continue;
            
            if(tasks[i].getTeam().getName().equals(teamName) && tasks[i].getNo() == taskNo)
                    return tasks[i];
        }
        
        return null;
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(Task task) {
        tasks[task.getNo()] = null;
    }
=======
        public void delete(int taskNo) {
            int i = this.getTaskIndex(taskNo);
            
            if( i != -1)
                tasks[i] = null;
        }
        
        private int getTaskIndex(int taskNo) {
            for(int i=0; i<tasks.length; i++) {
                if(tasks[i].getTaskNo() == taskNo) {
                   return i;
                }
            }
            return -1;
        }
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
}

// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





