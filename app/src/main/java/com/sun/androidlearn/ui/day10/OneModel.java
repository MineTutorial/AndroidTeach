package com.sun.androidlearn.ui.day10;

import java.io.Serializable;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/12
 * Question:
 * Description:
 * Train of thought:
 */
public class OneModel implements Serializable {

    /**
     * code : 200
     * msg : 成功
     * data : [{"src":"http://image.wufazhuce.com/Fqabwjm6WVm9Ff57qEuusfmDA1Y0","text":"我恨自己别无选择，只能冒险爱你。","day":"VOL.2775 12 May 2020"},{"src":"http://image.wufazhuce.com/Fp3Pl_3CbJsGMIRPPgzvkJxgYdqy","text":"好好忍耐，不要沮丧。你想，如果春天要来，大地就使它一点点地完成。","day":"VOL.2774 11 May 2020"},{"src":"http://image.wufazhuce.com/Fk9yhBb96P1L5ctoBudK4gEqpS9y","text":"不要怕死，也不要怕活着。不要怕爱，也不要怕忘记。 \u200b","day":"VOL.2773 10 May 2020"},{"src":"http://image.wufazhuce.com/FrsIOQVSU7PHg_oyd6dIxVwuNhvR","text":"有时间绝望的话，还不如吃点好吃的然后睡个好觉。","day":"VOL.2772 9 May 2020"},{"src":"http://image.wufazhuce.com/Fgoa3VVOm9VB7PdAu0kaH5fPdFwx","text":"对爱情的渴望，对知识的追求，对人类苦难不可遏制的同情心，这三种纯洁但无比强烈的激情支配着我的一生。","day":"VOL.2771 8 May 2020"},{"src":"http://image.wufazhuce.com/FsT4YEfFgrmI094CeAnkV6cmvoGP","text":"人之所以能够感到\u201c幸福\u201d，不是因为生活得舒适，而是因为生活得有希望。","day":"VOL.2770 7 May 2020"},{"src":"http://image.wufazhuce.com/FpNcpQ9V8MN6RullPL7x6vjfowXS","text":"交谈如果超过理解的限度可能就是一种破坏，一种炫耀。","day":"VOL.2769 6 May 2020"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * src : http://image.wufazhuce.com/Fqabwjm6WVm9Ff57qEuusfmDA1Y0
         * text : 我恨自己别无选择，只能冒险爱你。
         * day : VOL.2775 12 May 2020
         */

        private String src;
        private String text;
        private String day;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }
    }
}
