package io.github.tanghuibo.onepiecestudyweb.request;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:48
 */
public class GroupInfoAddRequest {
    /**
     * 用户名
     */
    private String name;

    /**
     * 备注
     */
    private String noteInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo;
    }
}
