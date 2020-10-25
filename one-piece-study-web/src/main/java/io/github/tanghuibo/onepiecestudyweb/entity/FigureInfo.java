package io.github.tanghuibo.onepiecestudyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 海贼王人物信息
 * </p>
 *
 * @author thb
 * @since 2020-10-25
 */
@TableName("figure_info")
public class FigureInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String userName;

    /**
     * 技能
     */
    private String userSkill;

    /**
     * 恶魔果实
     */
    private String devilNuts;

    /**
     * 战斗力
     */
    private Integer userFight;

    /**
     * 备注
     */
    private String commentInfo;

    /**
     * 扩展字段
     */
    private String attribute;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(String userSkill) {
        this.userSkill = userSkill;
    }
    public String getDevilNuts() {
        return devilNuts;
    }

    public void setDevilNuts(String devilNuts) {
        this.devilNuts = devilNuts;
    }
    public Integer getUserFight() {
        return userFight;
    }

    public void setUserFight(Integer userFight) {
        this.userFight = userFight;
    }
    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FigureInfo{" +
        "id=" + id +
        ", userName=" + userName +
        ", userSkill=" + userSkill +
        ", devilNuts=" + devilNuts +
        ", userFight=" + userFight +
        ", commentInfo=" + commentInfo +
        ", attribute=" + attribute +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
