class TaskManager {
    static class Node {
        final int taskId, priority;
        Node(int taskId, int priority) { this.taskId = taskId; this.priority = priority; }
    }

    // priority desc, then taskId desc  ← matches your expected behavior
    private static final Comparator<Node> CMP = (a, b) -> {
        int c = Integer.compare(b.priority, a.priority);
        return c != 0 ? c : Integer.compare(b.taskId, a.taskId);
    };

    private final TreeSet<Node> all = new TreeSet<>(CMP);
    private final Map<Integer, Integer> taskToUser = new HashMap<>();
    private final Map<Integer, Integer> taskToPriority = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        Integer old = taskToPriority.get(taskId);
        if (old != null) { // avoid ghost duplicates if same taskId re-added
            edit(taskId, priority);
            taskToUser.put(taskId, userId);
            return;
        }
        taskToUser.put(taskId, userId);
        taskToPriority.put(taskId, priority);
        all.add(new Node(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        Integer old = taskToPriority.get(taskId);
        if (old == null) return; // or throw
        all.remove(new Node(taskId, old));
        all.add(new Node(taskId, newPriority));
        taskToPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        Integer old = taskToPriority.remove(taskId);
        if (old == null) return; // or throw
        all.remove(new Node(taskId, old));
        taskToUser.remove(taskId);
    }

    public int execTop() {
        if (all.isEmpty()) return -1;
        Node top = all.first();           // highest priority, then largest taskId
        int userId = taskToUser.get(top.taskId);
        rmv(top.taskId);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */