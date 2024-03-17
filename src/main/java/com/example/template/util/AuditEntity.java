package com.example.template.util;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public abstract class AuditEntity {

  @Column(name = "created_by")
  private Long createdBy;

  @Column(name = "updated_by")
  private Long updatedBy;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private Timestamp createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private Timestamp updatedAt;

  /**
   * Fetches the user who created
   *
   * @return Long
   */
  public Long getCreatedBy() {
    return createdBy;
  }

  /**
   * Sets the user who created
   *
   * @param createdBy The user who created
   */
  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Fetches the user who updated
   *
   * @return Long
   */
  public Long getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Sets the user who updated
   *
   * @param updatedBy The user who updated
   */
  public void setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * Fetches the time of creation
   *
   * @return Timestamp
   */
  public Timestamp getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the time of creation
   *
   * @param createdAt The time of creation
   */
  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Fetches the time of update
   *
   * @return Timestamp
   */
  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Sets the time of udpate
   *
   * @param updatedAt The time of update
   */
  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  @PrePersist
  public void prePersist() {
    var authenticatedService = BeanUtils.getBean(IAuthenticatedUserService.class);
    this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    this.createdBy = authenticatedService.getUserId();
  }

  @PreUpdate
  public void preUpdate() {
    var authenticatedService = BeanUtils.getBean(IAuthenticatedUserService.class);
    this.updatedBy = authenticatedService.getUserId();
  }
}
