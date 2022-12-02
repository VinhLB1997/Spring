package spring.springdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "version")
public class Version {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "version_no", nullable = false, length = 10)
    private String versionNo;

    @Column(name = "device_type", nullable = false)
    private Integer deviceType;

    @Column(name = "file_key", nullable = false, length = 512)
    private String fileKey;

    @Column(name = "change_point", length = 256)
    private String changePoint;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "delete_flag", nullable = false)
    private Boolean deleteFlag = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getChangePoint() {
        return changePoint;
    }

    public void setChangePoint(String changePoint) {
        this.changePoint = changePoint;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}