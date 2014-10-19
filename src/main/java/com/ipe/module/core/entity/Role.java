package com.ipe.module.core.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ipe.common.entity.IDEntity;
import com.ipe.common.util.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: tangdu
 * Date: 13-9-7
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","authorities", "userRoles"})
@Table(name = "t_cor_role", schema = "", catalog = Constants.SCHEMA)
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IDEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2523883218705387949L;
	private String roleName;

    @Column(name = "role_name", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String enabled;

    @Column(name = "enabled_", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    private String remark;

    @Column(name = "remark_", nullable = true, insertable = true, updatable = true, length = 1000, precision = 0)
    @Basic
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Date createdDate;

    @Column(name = "created_date", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private Date updatedDate;

    @Column(name = "updated_date", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    //关联权限
    private Collection<Authority> authorities;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    //关联用户角色
    private Collection<UserRole> userRoles;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    public Collection<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}