public enum EditorState{
    EDITORSTATE_MOVING("Moving Nodes"),
    EDITORSTATE_DELETING("Delete Nodes"),
    EDITORSTATE_CONNECTING ("Connect Nodes"),
    EDITORSTATE_CREATING("Create Nodes"),
    EDITORSTATE_DELETING_DESTINATION("Delete destination"),
    EDITORSTATE_CREATING_DESTINATION ("Create destination");

    private String command_;

    private EditorState (String command){
        command_ = command;
    }

    @Override 
    public String toString(){
        return command_;
    }
}