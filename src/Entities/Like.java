package Entities;

public class Like {
    private int id_user;
    private int id_post;
    private boolean likevalue;

    public Like(int id_user, int id_post, boolean likevalue) {
        this.id_user = id_user;
        this.id_post = id_post;
        this.likevalue = likevalue;
    }

    
}
