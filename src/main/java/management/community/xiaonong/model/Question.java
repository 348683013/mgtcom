package management.community.xiaonong.model;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.ID
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.TITLE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.CREATOR
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.TAG
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.DESCRIPTION
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.ID
     *
     * @return the value of question.ID
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.ID
     *
     * @param id the value for question.ID
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.TITLE
     *
     * @return the value of question.TITLE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.TITLE
     *
     * @param title the value for question.TITLE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.GMT_CREATE
     *
     * @return the value of question.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.GMT_CREATE
     *
     * @param gmtCreate the value for question.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.GMT_MODIFIED
     *
     * @return the value of question.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.GMT_MODIFIED
     *
     * @param gmtModified the value for question.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.CREATOR
     *
     * @return the value of question.CREATOR
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.CREATOR
     *
     * @param creator the value for question.CREATOR
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.COMMENT_COUNT
     *
     * @return the value of question.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.COMMENT_COUNT
     *
     * @param commentCount the value for question.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.VIEW_COUNT
     *
     * @return the value of question.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.VIEW_COUNT
     *
     * @param viewCount the value for question.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.LIKE_COUNT
     *
     * @return the value of question.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.LIKE_COUNT
     *
     * @param likeCount the value for question.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.TAG
     *
     * @return the value of question.TAG
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.TAG
     *
     * @param tag the value for question.TAG
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.DESCRIPTION
     *
     * @return the value of question.DESCRIPTION
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.DESCRIPTION
     *
     * @param description the value for question.DESCRIPTION
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}