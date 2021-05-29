package sample;

import javafx.beans.property.SimpleStringProperty;

public class vemaybay {
       private SimpleStringProperty tennguoimua;
        private String socmt;
        private String noidi;
        private String noiden;
       private int quangduongbay;
private String thoigianbay;
private String thoigianbanve;

private int giave;


        public vemaybay(SimpleStringProperty tennguoimua, String socmt, String noidi, String noiden, int quangduongbay, String thoigianbay, String thoigianbanve, int giave) {
            this.tennguoimua = tennguoimua;
            this.socmt = socmt;
            this.noidi = noidi;
            this.noiden = noiden;
            this.quangduongbay = quangduongbay;
            this.thoigianbay= thoigianbay;
            this.thoigianbanve = thoigianbanve;
            this.giave = giave;
        }

        public vemaybay() {

        }

        public String getTennguoimua() {
            return tennguoimua.get();
        }
        public String getSocmt() {
            return socmt;
        }
        public String getNoidi() {
            return noidi;
        }
        public String getNoiden() {
            return noiden;
        }

        public String getThoigianbanve() {
            return thoigianbanve;
        }


        public int getQuangduongbay() {
            return quangduongbay;
        }

        public String getThoigianbay() {
            return thoigianbay;
        }

        public int getGiave() {
            return giave;
        }

        public void setTennguoimua(String tennguoimua) {
            this.tennguoimua = new SimpleStringProperty(tennguoimua);
        }

        public void setSocmt(String socmt) {
            this.socmt = socmt;
        }

        public void setNoidi(String noidi) {
            this.noidi = noidi;
        }

        public void setNoiden(String noiden) {
            this.noiden = noiden;
        }

        public void setQuangduongbay(int quangduongbay) {
            this.quangduongbay = quangduongbay;
        }

        public void setThoigianbay(String thoigianbay) {
            this.thoigianbay = thoigianbay;
        }

        public void setThoigianbanve(String thoigianbanve) {
            this.thoigianbanve = thoigianbanve;
        }

        public void setGiave(int giave) {
            this.giave = giave;
        }
    }



