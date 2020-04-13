package com.bishe.java.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomUtil {

        public static String getAddr(){
            List<String> list=new ArrayList<>();
            list.add("上海");
            list.add("上海");list.add("上海");
            list.add("上海");list.add("上海");list.add("上海");list.add("上海");list.add("上海");
            list.add("上海");list.add("上海");list.add("上海");list.add("上海");list.add("上海");
            list.add("上海");list.add("上海");list.add("上海");list.add("上海");list.add("上海");
            list.add("上海");list.add("上海");list.add("上海");list.add("上海");list.add("上海");
            list.add("北京");
            list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");
            list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");list.add("北京");
            list.add("北京");list.add("北京");list.add("北京");list.add("北京");
            list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");list.add("江苏");
            list.add("江苏");list.add("江苏");
            list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");
            list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");list.add("深圳");
            list.add("深圳");list.add("深圳");list.add("深圳");
            list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");
            list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");
            list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");list.add("广州");
            list.add("海门");
            list.add("鄂尔多斯");
            list.add("招远");
            list.add("舟山");
            list.add("齐齐哈尔");
            list.add("盐城");
            list.add("赤峰");
            list.add("青岛");
            list.add("乳山");
            list.add("金昌");
            list.add("泉州");
            list.add("莱西");
            list.add("日照");
            list.add("胶南");
            list.add("南通");
            list.add("拉萨");
            list.add("云浮");
            list.add("梅州");
            list.add("文登");
            list.add("上海");
            list.add("攀枝花");
            list.add("威海");
            list.add("承德");
            list.add("厦门");
            list.add("汕尾");
            list.add("潮州");
            list.add("丹东");
            list.add("太仓");
            list.add("曲靖");
            list.add("烟台");
            list.add("福州");
            list.add("瓦房店");
            list.add("即墨");
            list.add("抚顺");
            list.add("玉溪");
            list.add("张家口");
            list.add("阳泉");
            list.add("莱州");
            list.add("湖州");
            list.add("汕头");
            list.add("昆山");
            list.add("宁波");
            list.add("湛江");
            list.add("揭阳");
            list.add("荣成");
            list.add("连云港");
            list.add("葫芦岛");
            list.add("常熟");
            list.add("东莞");
            list.add("河源");
            list.add("淮安");
            list.add("泰州");
            list.add("南宁");
            list.add("营口");
            list.add("惠州");
            list.add("江阴");
            list.add("蓬莱");
            list.add("韶关");
            list.add("嘉峪关");
            list.add("广州");
            list.add("延安");
            list.add("太原");
            list.add("清远");
            list.add("中山");
            list.add("昆明");
            list.add("寿光");
            list.add("盘锦");
            list.add("长治");
            list.add("深圳");
            list.add("珠海");
            list.add("宿迁");
            list.add("咸阳");
            list.add("铜川");
            list.add("平度");
            list.add("佛山");
            list.add("海口");
            list.add("江门");
            list.add("章丘");
            list.add("肇庆");
            list.add("大连");
            list.add("临汾");
            list.add("吴江");
            list.add("石嘴山");
            list.add("沈阳");
            list.add("苏州");
            list.add("茂名");
            list.add("嘉兴");
            list.add("长春");
            list.add("胶州");
            list.add("银川");
            list.add("张家港");
            list.add("三门峡");
            list.add("锦州");
            list.add("南昌");
            list.add("柳州");
            list.add("三亚");
            list.add("自贡");
            list.add("吉林");
            list.add("阳江");
            list.add("泸州");
            list.add("西宁");
            list.add("宜宾");
            list.add("呼和浩特");
            list.add("成都");
            list.add("大同");
            list.add("镇江");
            list.add("桂林");
            list.add("张家界");
            list.add("宜兴");
            list.add("北海");
            list.add("西安");
            list.add("金坛");
            list.add("东营");
            list.add("牡丹江");
            list.add("遵义");
            list.add("绍兴");
            list.add("扬州");
            list.add("常州");
            list.add("潍坊");
            list.add("重庆");
            list.add("台州");
            list.add("南京");
            list.add("滨州");
            list.add("贵阳");
            list.add("无锡");
            list.add("本溪");
            list.add("克拉玛依");
            list.add("渭南");
            list.add("马鞍山");
            list.add("宝鸡");
            list.add("焦作");
            list.add("句容");
            list.add("北京");
            list.add("徐州");
            list.add("衡水");
            list.add("包头");
            list.add("绵阳");
            list.add("乌鲁木齐");
            list.add("枣庄");
            list.add("杭州");
            list.add("淄博");
            list.add("鞍山");
            list.add("溧阳");
            list.add("库尔勒");
            list.add("安阳");
            list.add("开封");
            list.add("济南");
            list.add("德阳");
            list.add("温州");
            list.add("九江");
            list.add("邯郸");
            list.add("临安");
            list.add("兰州");
            list.add("沧州");
            list.add("临沂");
            list.add("南充");
            list.add("天津");
            list.add("富阳");
            list.add("泰安");
            list.add("诸暨");
            list.add("郑州");
            list.add("哈尔滨");
            list.add("聊城");
            list.add("芜湖");
            list.add("唐山");
            list.add("平顶山");
            list.add("邢台");
            list.add("德州");
            list.add("济宁");
            list.add("荆州");
            list.add("宜昌");
            list.add("义乌");
            list.add("丽水");
            list.add("洛阳");
            list.add("秦皇岛");
            list.add("株洲");
            list.add("石家庄");
            list.add("莱芜");
            list.add("常德");
            list.add("保定");
            list.add("湘潭");
            list.add("金华");
            list.add("岳阳");
            list.add("长沙");
            list.add("衢州");
            list.add("廊坊");
            list.add("菏泽");
            list.add("合肥");
            list.add("武汉");
            list.add("大庆");
            return  list.get(getNum(0,list.size()-1));
        }

        public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
        private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

        public static int getNum(int start,int end) {
            return (int)(Math.random()*(end-start+1)+start);
        }


        /**
         * 返回手机号码
         */


        /**
         * 返回中文姓名
         */
        private static String name_sex = "";
        public static String getSex(){
            int sex=getNum(0,2);
            return sex==0?"女":"男";
        }
    public static Boolean getCheck(){
        int num=getNum(0,100);
        return num<=98?true:false;
    }
    public static String getType(){
        int sex=getNum(0,2);
        return sex==0?"普通员工":"管理员";
    }
    public static String getCaiXiaoType(){
        int sex=getNum(0,2);
        return sex==0?"采购":"销售";
    }
    public static String getChineseName() {
            int index=getNum(0, firstName.length()-1);
            String first=firstName.substring(index, index+1);
            int sex=getNum(0,1);
            String str=boy;
            int length=boy.length();
            if(sex==0){
                str=girl;
                length=girl.length();
                name_sex = "女";
            }else {
                name_sex="男";
            }
            index=getNum(0,length-1);
            String second=str.substring(index, index+1);
            int hasThird=getNum(0,1);
            String third="";
            if(hasThird==1){
                index=getNum(0,length-1);
                third=str.substring(index, index+1);
            }
            return first+second+third;
        }


        public  static  Integer getAge(){
            Random random=new Random();
            return random.nextInt(60)+10;

        }



        public  static  String  getTime(){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return  simpleDateFormat.format(new Date());
        }
    public  static  String  getHour(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH");
        return  simpleDateFormat.format(new Date());
    }
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }






}
