package com.portfolio.usermaster.validation;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * ユーザーEntityクラスののFormクラス.
 */

public class UserBaseForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max=30)
    private String name;

    private String role;


    private boolean enabled;


    public UserBaseForm() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getRole() {
        return role;
    }



    public void setRole(String role) {
        this.role = role;
    }



    public boolean isEnabled() {
        return enabled;
    }



    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * ロールの選択肢の定数を取得するメソッド.
     * @return 選択肢の定数
     */
    public Map<String,String> getRoleItems(){
        Map<String,String> roleItems = new LinkedHashMap<String, String>();
        roleItems.put("SHOW", "SHOW");
        roleItems.put("EDIT", "EDIT");
        return roleItems;
    }


    /**
     * 有効フラグの選択肢の定数を取得するメソッド.
     * @return 選択肢の定数
     */
    public Map<String, Boolean> getEnabledItems(){
        Map<String, Boolean>  enabledItems = new LinkedHashMap<String, Boolean>();
        enabledItems.put("true", true);
        enabledItems.put("false", false);
        return enabledItems;
    }
}
