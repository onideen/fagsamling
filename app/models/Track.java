package models;

import org.markdown4j.Markdown4jProcessor;
import play.db.ebean.Model;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */

@Entity
public class Track extends Model {

    @Id
    private long id;

    private String title;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    private List<Instructor> instructors;

    private String host;
    private String format;
    private String level;
    private String room;
    private String equipments;

    @Column(columnDefinition  = "TEXT")
    private String summary;

    private String audience;
    private List<Requirement> requirements;

    @Column(columnDefinition = "TEXT")
    private String htmlContent;

    @Column(columnDefinition = "TEXT")
    private String markdownContent;

    public Track(){
        this.instructors = new ArrayList<>();
    }

    private static Finder<Long, Track> find = new Finder<Long, Track>(Long.class, Track.class);

    public static List<Track> findAll() {
        return find.all();
    }

    public static Track findById(long id) {
        return find.byId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public boolean isNew(){
        return id == 0;
    }

    public String getInstructorsAsString() {
        return StringUtils.join(instructors, ",");
    }

    public List<Instructor> getInstructors(){
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void setContent(String content) {
        this.markdownContent = content;
        try {
            this.htmlContent = new Markdown4jProcessor().process(content);
        } catch (IOException e) {}
    }

    public String getEquipments() {
        return equipments;
    }

    public String[] getEquipmentAsArray(){
        return equipments.split(";");
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }
}
