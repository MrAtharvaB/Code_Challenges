import java.util.Stack;

class Solution {
    private StringBuilder document = new StringBuilder();
    private Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        document.append(x);
        redoStack.clear();
    }

    public void undo() {
        if (document.length() > 0) {
            redoStack.push(document.charAt(document.length() - 1));
            document.deleteCharAt(document.length() - 1);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            document.append(redoStack.pop());
        }
    }

    public String read() {
        return document.toString();
    }
}
