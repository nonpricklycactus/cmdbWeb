package com.wxk.cmdb.domain.WebData;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/4/19
 */
public class carteChildren {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    private String href;
    private String icon;

    private String fontFamily;
    private String spread;
}
