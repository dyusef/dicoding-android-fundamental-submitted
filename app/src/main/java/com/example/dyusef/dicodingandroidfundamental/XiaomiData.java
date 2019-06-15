package com.example.dyusef.dicodingandroidfundamental;

import java.util.ArrayList;

public class XiaomiData {
    public static String[][] data = new String[][]{
            {"Mi 9", "Rp. x.xxx.xxx"},
            {"Mi 8 Explore Editios", "Rp. x.xxx.xxx"},
            {"Mi 8", "Rp. x.xxx.xxx"},
            {"Mi 8 Lite", "Rp. x.xxx.xxx"},
            {"Mi 8 SE", "Rp. x.xxx.xxx"},
            {"Redmi Note 7 Pro", "Rp. x.xxx.xxx"},
            {"Pochopone", "Rp. x.xxx.xxx"},
            {"Black Shark 2", "Rp. x.xxx.xxx"},
            {"Black Shark", "Rp. x.xxx.xxx"},
            {"MIA2", "Rp. x.xxx.xxx"}
    };

    public static int[][] dataPicDesc = new int[][]{
            {R.mipmap.xiaomi_mi_9_, R.string.descMi9},
            {R.mipmap.xiaomi_mi8_explore_, R.string.descMi8Explore},
            {R.mipmap.xiaomi_mi_8_pro_, R.string.dsscMi8Pro},
            {R.mipmap.xiaomi_mi_8_lite_, R.string.descMi8Lite},
            {R.mipmap.xiaomi_mi8_se,R.string.descMi8SE},
            {R.mipmap.xiaomi_redmi_note_7_pro, R.string.descRenote7Pro},
            {R.mipmap.xiaomi_pocophone_f1_, R.string.descPocophoneF1},
            {R.mipmap.xiaomi_black_shark_2, R.string.descBlackShark2},
            {R.mipmap.xiaomi_black_shark2, R.string.descBlackShark},
            {R.mipmap.xiaomi_mi_a2_, R.string.descMiA2}
    };

    public static ArrayList<Xiaomi> getListData(){
        Xiaomi xiaomi = null;
        ArrayList<Xiaomi> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            xiaomi = new Xiaomi();
            xiaomi.setName(data[i][0]);
            xiaomi.setPrice(data[i][1]);
            xiaomi.setPhoto(dataPicDesc[i][0]);
            xiaomi.setDesc(dataPicDesc[i][1]);

            list.add(xiaomi);
        }

        return list;
    }
}