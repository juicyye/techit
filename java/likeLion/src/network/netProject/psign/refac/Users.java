package network.netProject.psign.refac;

public class Users {
    private Long id;
    private String name;
    private Integer currentRoom;

    public Users(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Integer currentRoom) {
        this.currentRoom = currentRoom;
    }
}
