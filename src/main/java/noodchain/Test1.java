package noodchain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @program: source-demo
 * @description:
 * @ClassName：Test1
 * @author: Mr.Wang
 * @create: 2022-04-11 21:09
 **/
public class Test1 {

    public static void main(String[] args) {
        String s1 = "{\n" +
                "    \"returnCode\": \"00000\",\n" +
                "    \"userInfo\": \"user\",\n" +
                "    \"returnMsg\": \"成功\",\n" +
                "    \"logId\": \"1509798390503579648\",\n" +
                "    \"Data\": {\n" +
                "        \"imagetype\": \"血压监测表\",\n" +
                "        \"probability\": \"0.3013829887\",\n" +
                "        \"imageCode\": \"monitoring_form\",\n" +
                "        \"imagedata\": {\n" +
                "            \"commonData\": {\n" +
                "                \"房间号\": {\n" +
                "                    \"itemConf\": \"0.9862179930743331\",\n" +
                "                    \"originalName\": \"房间号\",\n" +
                "                    \"width\": 138,\n" +
                "                    \"x\": 663,\n" +
                "                    \"y\": 573,\n" +
                "                    \"value\": {\n" +
                "                        \"itemConf\": \"0\",\n" +
                "                        \"originalName\": \"8#1-1906\",\n" +
                "                        \"standardName\": \"8#1-1906\",\n" +
                "                        \"width\": 138,\n" +
                "                        \"x\": 663,\n" +
                "                        \"y\": 573,\n" +
                "                        \"height\": 45\n" +
                "                    },\n" +
                "                    \"height\": 45\n" +
                "                },\n" +
                "                \"居民姓名\": {\n" +
                "                    \"itemConf\": \"0.962190533934653\",\n" +
                "                    \"originalName\": \"居民姓名\",\n" +
                "                    \"width\": 192,\n" +
                "                    \"x\": 1101,\n" +
                "                    \"y\": 567,\n" +
                "                    \"value\": {\n" +
                "                        \"itemConf\": \"0\",\n" +
                "                        \"originalName\": \"韩嘉\",\n" +
                "                        \"standardName\": \"韩嘉\",\n" +
                "                        \"width\": 192,\n" +
                "                        \"x\": 1101,\n" +
                "                        \"y\": 567,\n" +
                "                        \"height\": 45\n" +
                "                    },\n" +
                "                    \"height\": 45\n" +
                "                },\n" +
                "                \"园区\": {\n" +
                "                    \"itemConf\": \"0.8097055114660048\",\n" +
                "                    \"originalName\": \"园区\",\n" +
                "                    \"width\": 222,\n" +
                "                    \"x\": 298,\n" +
                "                    \"y\": 571,\n" +
                "                    \"value\": {\n" +
                "                        \"itemConf\": \"0\",\n" +
                "                        \"originalName\": \"燕园\",\n" +
                "                        \"standardName\": \"燕园\",\n" +
                "                        \"width\": 222,\n" +
                "                        \"x\": 298,\n" +
                "                        \"y\": 571,\n" +
                "                        \"height\": 49\n" +
                "                    },\n" +
                "                    \"height\": 49\n" +
                "                }\n" +
                "            },\n" +
                "            \"tableData\": [\n" +
                "                {\n" +
                "                    \"valuelist\": [\n" +
                "                        {\n" +
                "                            \"单位\": {\n" +
                "                                \"itemConf\": \"0.7975923265778228\",\n" +
                "                                \"originalName\": \"mmHg \",\n" +
                "                                \"standardName\": \"mmHg\",\n" +
                "                                \"width\": 99,\n" +
                "                                \"x\": 1041,\n" +
                "                                \"y\": 831,\n" +
                "                                \"height\": 32\n" +
                "                            },\n" +
                "                            \"睡前\": {\n" +
                "                                \"itemConf\": \"0.7938304104407005\",\n" +
                "                                \"originalName\": \"120\",\n" +
                "                                \"standardName\": \"120\",\n" +
                "                                \"width\": 83,\n" +
                "                                \"x\": 1781,\n" +
                "                                \"y\": 812,\n" +
                "                                \"height\": 47\n" +
                "                            },\n" +
                "                            \"序号\": {\n" +
                "                                \"itemConf\": \"0.7827402759845317\",\n" +
                "                                \"originalName\": \"1\",\n" +
                "                                \"standardName\": \"1\",\n" +
                "                                \"width\": 26,\n" +
                "                                \"x\": 280,\n" +
                "                                \"y\": 830,\n" +
                "                                \"height\": 29\n" +
                "                            },\n" +
                "                            \"晨起\": {\n" +
                "                                \"itemConf\": \"0.8580944439392717\",\n" +
                "                                \"originalName\": \"95\",\n" +
                "                                \"standardName\": \"95\",\n" +
                "                                \"width\": 64,\n" +
                "                                \"x\": 1233,\n" +
                "                                \"y\": 817,\n" +
                "                                \"height\": 60\n" +
                "                            },\n" +
                "                            \"下午\": {\n" +
                "                                \"itemConf\": \"0.8229833564954698\",\n" +
                "                                \"originalName\": \"15\",\n" +
                "                                \"standardName\": \"15\",\n" +
                "                                \"width\": 70,\n" +
                "                                \"x\": 1622,\n" +
                "                                \"y\": 812,\n" +
                "                                \"height\": 49\n" +
                "                            },\n" +
                "                            \"日期\": {\n" +
                "                                \"itemConf\": \"0.7880788617534439\",\n" +
                "                                \"originalName\": \"2022/1/17\",\n" +
                "                                \"standardName\": \"2022-01-17\",\n" +
                "                                \"width\": 181,\n" +
                "                                \"x\": 393,\n" +
                "                                \"y\": 829,\n" +
                "                                \"height\": 38\n" +
                "                            },\n" +
                "                            \"项目\": {\n" +
                "                                \"itemConf\": \"0.7391317251201467\",\n" +
                "                                \"originalName\": \"血压收缩压\",\n" +
                "                                \"standardName\": \"血压收缩压\",\n" +
                "                                \"width\": 179,\n" +
                "                                \"x\": 793,\n" +
                "                                \"y\": 826,\n" +
                "                                \"height\": 37\n" +
                "                            },\n" +
                "                            \"上午\": {\n" +
                "                                \"itemConf\": \"0.7927522073359112\",\n" +
                "                                \"originalName\": \"110\",\n" +
                "                                \"standardName\": \"110\",\n" +
                "                                \"width\": 67,\n" +
                "                                \"x\": 1421,\n" +
                "                                \"y\": 814,\n" +
                "                                \"height\": 52\n" +
                "                            },\n" +
                "                            \"星期\": {\n" +
                "                                \"itemConf\": \"0.8902858011793707\",\n" +
                "                                \"originalName\": \"一\",\n" +
                "                                \"standardName\": \"一\",\n" +
                "                                \"width\": 1,\n" +
                "                                \"x\": -1,\n" +
                "                                \"y\": -1,\n" +
                "                                \"height\": 1\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"单位\": {\n" +
                "                                \"itemConf\": \"0.7888286300685914\",\n" +
                "                                \"originalName\": \"mmHg \",\n" +
                "                                \"standardName\": \"mmHg\",\n" +
                "                                \"width\": 102,\n" +
                "                                \"x\": 1040,\n" +
                "                                \"y\": 928,\n" +
                "                                \"height\": 30\n" +
                "                            },\n" +
                "                            \"睡前\": {\n" +
                "                                \"itemConf\": \"0.9894645566636893\",\n" +
                "                                \"originalName\": \"75\",\n" +
                "                                \"standardName\": \"75\",\n" +
                "                                \"width\": 75,\n" +
                "                                \"x\": 1798,\n" +
                "                                \"y\": 912,\n" +
                "                                \"height\": 63\n" +
                "                            },\n" +
                "                            \"序号\": {\n" +
                "                                \"itemConf\": \"0.7271233898350152\",\n" +
                "                                \"originalName\": \"2\",\n" +
                "                                \"standardName\": \"2\",\n" +
                "                                \"width\": 28,\n" +
                "                                \"x\": 272,\n" +
                "                                \"y\": 925,\n" +
                "                                \"height\": 33\n" +
                "                            },\n" +
                "                            \"晨起\": {\n" +
                "                                \"itemConf\": \"0.9597229459445383\",\n" +
                "                                \"originalName\": \"70\",\n" +
                "                                \"standardName\": \"70\",\n" +
                "                                \"width\": 65,\n" +
                "                                \"x\": 1242,\n" +
                "                                \"y\": 924,\n" +
                "                                \"height\": 55\n" +
                "                            },\n" +
                "                            \"下午\": {\n" +
                "                                \"itemConf\": \"0.8349828453733734\",\n" +
                "                                \"originalName\": \"75\",\n" +
                "                                \"standardName\": \"75\",\n" +
                "                                \"width\": 76,\n" +
                "                                \"x\": 1624,\n" +
                "                                \"y\": 921,\n" +
                "                                \"height\": 55\n" +
                "                            },\n" +
                "                            \"日期\": {\n" +
                "                                \"itemConf\": \"0.9708287236239206\",\n" +
                "                                \"originalName\": \"2022/1/17\",\n" +
                "                                \"standardName\": \"2022-01-17\",\n" +
                "                                \"width\": 181,\n" +
                "                                \"x\": 392,\n" +
                "                                \"y\": 925,\n" +
                "                                \"height\": 40\n" +
                "                            },\n" +
                "                            \"项目\": {\n" +
                "                                \"itemConf\": \"0.9149806714578913\",\n" +
                "                                \"originalName\": \"血压舒张压\",\n" +
                "                                \"standardName\": \"血压舒张压\",\n" +
                "                                \"width\": 179,\n" +
                "                                \"x\": 794,\n" +
                "                                \"y\": 924,\n" +
                "                                \"height\": 37\n" +
                "                            },\n" +
                "                            \"上午\": {\n" +
                "                                \"itemConf\": \"0.7943842031977495\",\n" +
                "                                \"originalName\": \"75\",\n" +
                "                                \"standardName\": \"75\",\n" +
                "                                \"width\": 71,\n" +
                "                                \"x\": 1438,\n" +
                "                                \"y\": 922,\n" +
                "                                \"height\": 65\n" +
                "                            },\n" +
                "                            \"星期\": {\n" +
                "                                \"itemConf\": \"0.9595266855250353\",\n" +
                "                                \"originalName\": \"一\",\n" +
                "                                \"standardName\": \"一\",\n" +
                "                                \"width\": 1,\n" +
                "                                \"x\": -1,\n" +
                "                                \"y\": -1,\n" +
                "                                \"height\": 1\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"单位\": {\n" +
                "                                \"itemConf\": \"0.8955165622116328\",\n" +
                "                                \"originalName\": \"次/分钟\",\n" +
                "                                \"standardName\": \"次/分钟\",\n" +
                "                                \"width\": 119,\n" +
                "                                \"x\": 1029,\n" +
                "                                \"y\": 1020,\n" +
                "                                \"height\": 33\n" +
                "                            },\n" +
                "                            \"睡前\": {\n" +
                "                                \"itemConf\": \"0.7841939225920191\",\n" +
                "                                \"originalName\": \"80\",\n" +
                "                                \"standardName\": \"80\",\n" +
                "                                \"width\": 71,\n" +
                "                                \"x\": 1819,\n" +
                "                                \"y\": 1006,\n" +
                "                                \"height\": 52\n" +
                "                            },\n" +
                "                            \"序号\": {\n" +
                "                                \"itemConf\": \"0.8368083001102647\",\n" +
                "                                \"originalName\": \"3\",\n" +
                "                                \"standardName\": \"3\",\n" +
                "                                \"width\": 31,\n" +
                "                                \"x\": 268,\n" +
                "                                \"y\": 1022,\n" +
                "                                \"height\": 32\n" +
                "                            },\n" +
                "                            \"晨起\": {\n" +
                "                                \"itemConf\": \"0.9690701557368981\",\n" +
                "                                \"originalName\": \"65\",\n" +
                "                                \"standardName\": \"65\",\n" +
                "                                \"width\": 78,\n" +
                "                                \"x\": 1257,\n" +
                "                                \"y\": 1012,\n" +
                "                                \"height\": 59\n" +
                "                            },\n" +
                "                            \"下午\": {\n" +
                "                                \"itemConf\": \"0.731230413645079\",\n" +
                "                                \"originalName\": \"80\",\n" +
                "                                \"standardName\": \"80\",\n" +
                "                                \"width\": 57,\n" +
                "                                \"x\": 1626,\n" +
                "                                \"y\": 1008,\n" +
                "                                \"height\": 49\n" +
                "                            },\n" +
                "                            \"日期\": {\n" +
                "                                \"itemConf\": \"0.7838213367507345\",\n" +
                "                                \"originalName\": \"2022/1/17\",\n" +
                "                                \"standardName\": \"2022-01-17\",\n" +
                "                                \"width\": 183,\n" +
                "                                \"x\": 390,\n" +
                "                                \"y\": 1021,\n" +
                "                                \"height\": 41\n" +
                "                            },\n" +
                "                            \"项目\": {\n" +
                "                                \"itemConf\": \"0.8906464432458769\",\n" +
                "                                \"originalName\": \"心率\",\n" +
                "                                \"standardName\": \"心率\",\n" +
                "                                \"width\": 75,\n" +
                "                                \"x\": 845,\n" +
                "                                \"y\": 1020,\n" +
                "                                \"height\": 38\n" +
                "                            },\n" +
                "                            \"上午\": {\n" +
                "                                \"itemConf\": \"0.9248942393158851\",\n" +
                "                                \"originalName\": \"70\",\n" +
                "                                \"standardName\": \"70\",\n" +
                "                                \"width\": 71,\n" +
                "                                \"x\": 1450,\n" +
                "                                \"y\": 1016,\n" +
                "                                \"height\": 52\n" +
                "                            },\n" +
                "                            \"星期\": {\n" +
                "                                \"itemConf\": \"0.9508145270870623\",\n" +
                "                                \"originalName\": \"一\",\n" +
                "                                \"standardName\": \"一\",\n" +
                "                                \"width\": 1,\n" +
                "                                \"x\": -1,\n" +
                "                                \"y\": -1,\n" +
                "                                \"height\": 1\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"单位\": {\n" +
                "                                \"itemConf\": \"0.910343101617194\",\n" +
                "                                \"originalName\": \"mmHg \",\n" +
                "                                \"standardName\": \"mmHg\",\n" +
                "                                \"width\": 101,\n" +
                "                                \"x\": 1041,\n" +
                "                                \"y\": 1124,\n" +
                "                                \"height\": 31\n" +
                "                            },\n" +
                "                            \"睡前\": {\n" +
                "                                \"itemConf\": \"0.8388790039939694\",\n" +
                "                                \"originalName\": \"120\",\n" +
                "                                \"standardName\": \"120\",\n" +
                "                                \"width\": 74,\n" +
                "                                \"x\": 1809,\n" +
                "                                \"y\": 1115,\n" +
                "                                \"height\": 44\n" +
                "                            },\n" +
                "                            \"序号\": {\n" +
                "                                \"itemConf\": \"0.8557297189750152\",\n" +
                "                                \"originalName\": \"4\",\n" +
                "                                \"standardName\": \"4\",\n" +
                "                                \"width\": 1,\n" +
                "                                \"x\": -1,\n" +
                "                                \"y\": -1,\n" +
                "                                \"height\": 1\n" +
                "                            },\n" +
                "                            \"晨起\": {\n" +
                "                                \"itemConf\": \"0.8378504348823514\",\n" +
                "                                \"originalName\": \"100\",\n" +
                "                                \"standardName\": \"100\",\n" +
                "                                \"width\": 87,\n" +
                "                                \"x\": 1237,\n" +
                "                                \"y\": 1120,\n" +
                "                                \"height\": 47\n" +
                "                            },\n" +
                "                            \"下午\": {\n" +
                "                                \"itemConf\": \"0.884619641155177\",\n" +
                "                                \"originalName\": \"120\",\n" +
                "                                \"standardName\": \"120\",\n" +
                "                                \"width\": 79,\n" +
                "                                \"x\": 1629,\n" +
                "                                \"y\": 1104,\n" +
                "                                \"height\": 56\n" +
                "                            },\n" +
                "                            \"日期\": {\n" +
                "                                \"itemConf\": \"0.9074718046647283\",\n" +
                "                                \"originalName\": \"2022/1/18\",\n" +
                "                                \"standardName\": \"2022-01-18\",\n" +
                "                                \"width\": 183,\n" +
                "                                \"x\": 389,\n" +
                "                                \"y\": 1119,\n" +
                "                                \"height\": 39\n" +
                "                            },\n" +
                "                            \"项目\": {\n" +
                "                                \"itemConf\": \"0.769181783031208\",\n" +
                "                                \"originalName\": \"血压收缩压\",\n" +
                "                                \"standardName\": \"血压收缩压\",\n" +
                "                                \"width\": 180,\n" +
                "                                \"x\": 793,\n" +
                "                                \"y\": 1118,\n" +
                "                                \"height\": 38\n" +
                "                            },\n" +
                "                            \"上午\": {\n" +
                "                                \"itemConf\": \"0.9723244302496183\",\n" +
                "                                \"originalName\": \"110\",\n" +
                "                                \"standardName\": \"110\",\n" +
                "                                \"width\": 76,\n" +
                "                                \"x\": 1437,\n" +
                "                                \"y\": 1114,\n" +
                "                                \"height\": 51\n" +
                "                            },\n" +
                "                            \"星期\": {\n" +
                "                                \"itemConf\": \"0.899909369294833\",\n" +
                "                                \"originalName\": \"二\",\n" +
                "                                \"standardName\": \"二\",\n" +
                "                                \"width\": 46,\n" +
                "                                \"x\": 657,\n" +
                "                                \"y\": 1121,\n" +
                "                                \"height\": 35\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"keylist\": {\n" +
                "                        \"单位\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"单位\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"睡前\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"睡前\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"序号\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"序号\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"晨起\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"晨起\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"下午\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"下午\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"日期\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"日期\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"上午\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"上午\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"项目\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"项目\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        },\n" +
                "                        \"星期\": {\n" +
                "                            \"itemConf\": \"1.0\",\n" +
                "                            \"originalName\": \"星期\",\n" +
                "                            \"width\": 0,\n" +
                "                            \"x\": -1,\n" +
                "                            \"y\": -1,\n" +
                "                            \"height\": 0\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"y1\": 0,\n" +
                "        \"angle\": 0,\n" +
                "        \"x1\": 0,\n" +
                "        \"y2\": 0,\n" +
                "        \"x2\": 2160,\n" +
                "        \"y3\": 3840,\n" +
                "        \"x3\": 2160,\n" +
                "        \"y4\": 3840,\n" +
                "        \"x4\": 0\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s1);
        JSONObject data1 = jsonObject.getJSONObject("Data");
        JSONObject imagedata = data1.getJSONObject("imagedata");
        //System.out.println(imagedata);
        List<JSONObject> datas = JSONObject.parseArray(imagedata.getString("tableData"), JSONObject.class);
        //Set<String> keySet = new HashSet<>();
        for (JSONObject data : datas) {
            //System.out.println(data);
            if (data.containsKey("valuelist")) {
                JSONArray valuelist = JSONObject.parseObject(data.getString("valuelist"), JSONArray.class);
                //System.out.println(valuelist);
                HashMap<String, String> maps = new HashMap();
                maps.put("晨起","06:00");
                maps.put("上午","09:00");
                maps.put("下午","14:00");
                maps.put("睡前","20:00");
                Set<String> set = maps.keySet();
                List<Map<String, Object>> lists = new ArrayList();
                for (Object o : valuelist) {
                    JSONObject jsonObject1 = (JSONObject) o;
                    for (String s : set) {
                        HashMap<String, Object> map = new HashMap<>();
                        String vs_value = jsonObject1.getJSONObject(s).getString("originalName");
                        String vs_value1 = jsonObject1.getJSONObject("单位").getString("originalName");
                        String vs_name = jsonObject1.getJSONObject("项目").getString("originalName");
                        String vs_date = jsonObject1.getJSONObject("日期").getString("originalName");
                        map.put("vs_value",vs_value);
                        map.put("vs_name",vs_name);
                        map.put("vs_date",vs_date + " " + maps.get(s));
                        map.put("vs_group",s);
                        map.put("vs_",vs_value1);
                        lists.add(map);
                    }
                }
                lists.stream().forEach(System.out::println);
            }
        }
    }
}
