package pojos;

import java.util.ArrayList;

public class Component {
    public String id;
    public String name;
    public String status;
    public String created_at;
    public String updated_at;
    public int position;
    public String description;
    public boolean showcase;
    public String start_date;
    public String group_id;
    public String page_id;
    public boolean group;
    public boolean only_show_if_degraded;
    public ArrayList<String> components;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String isDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShowcase() {
        return showcase;
    }

    public void setShowcase(boolean showcase) {
        this.showcase = showcase;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isOnly_show_if_degraded() {
        return only_show_if_degraded;
    }

    public void setOnly_show_if_degraded(boolean only_show_if_degraded) {
        this.only_show_if_degraded = only_show_if_degraded;
    }

    public ArrayList<String> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
    }
}
