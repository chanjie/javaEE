package net.canway.entity;

public class Room {

    private long id;

    private String roomNum;

    private String type;

    private String status;

    private String customName;

    private long customId;

    public Room(long id, String roomNum, String type, String status, String customName, long customId) {
        this.id = id;
        this.roomNum = roomNum;
        this.type = type;
        this.status = status;
        this.customName = customName;
        this.customId = customId;
    }

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", customName='" + customName + '\'' +
                ", customId='" + customId + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public void setCustomId(long customId) {
        this.customId = customId;
    }

    public long getId() {
        return id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomName() {
        return customName;
    }

    public long getCustomId() {
        return customId;
    }
}
