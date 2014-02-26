/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.pdf;

import java.awt.Desktop;
import java.io.*;

public class GenerateHtml {
    public GenerateHtml(){
    }
    
    public void generateHtml(   String watermark,
                                String classification,
                                String missionNumber,
                                String leftFrom,
                                String leftTo,
                                String leftAdditionalText,
                                String cc,
                                String acc,
                                String stagingArea,
                                String rightFrom,
                                String rightTo,
                                String fromLU,
                                String toLU,
                                String fromSP,
                                String toSP){
        
        String classificationColor = "";
        
        if(classification.equalsIgnoreCase("SECRET")){
            classificationColor = "red";
        }
        else{
            classificationColor = "black";
        }
        
        try{
        File f = new File("src\\convoy\\resources\\html\\convoy.htm");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"\n" +
"<head>\n" +
"    <script type=\"text/javascript\" src=\"../javascript/jquery-latest.min.js\"></script>\n" +
"    <title></title>\n" +
"    <style type=\"text/css\">\n" +
"        body {\n" +
"            background-color: rgb(194, 178, 128);\n" +
"        }\n" +
"        div,\n" +
"        table {\n" +
"            width: 100%;\n" +
"            //border: 1px solid #000;\n" +
"            height: 100%;\n" +
"        }\n" +
"        td {\n" +
"            border: 1px solid #000;\n" +
"            background-color: white;\n" +
"        }\n" +
"        .label {\n" +
"            font-weight: bold;\n" +
"            font-family: capture;\n" +
"        }\n" +
"        .data {\n" +
"            text-align: center;\n" +
"        }\n" +
"        #freqTable {\n" +
"            border: 0;\n" +
"        }\n" +
"        .rows {\n" +
"            border: red solid 1px;\n" +
"            height: 33%;\n" +
"        }\n" +
"        .vehicle {\n" +
"            height: 250px;\n" +
"        }\n" +
"        #leftMissionInfo {\n" +
"            font-size: 16pt;\n" +
"            //background: url('" + watermark + "') no-repeat center center;\n" +
"        }\n" +
"        #leftMissionInfoTable {\n" +
"            opacity: 0.9;\n" +
"            -ms-filter: \"progid:DXImageTransform.Microsoft.Alpha(Opacity=90)\";\n" +
"            filter: alpha(opacity=90);\n" +
"        }\n" +
"        .additionalText {\n" +
"            height: 150px;\n" +
"        }\n" +
         "#classification{text-align: center;font-weight: bold;font-size: 24pt;color: " + classificationColor +";}\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <div>\n" +
"        <table>\n" +
"            <!-- main table //-->\n" +
"            <tr class=\"rows\">\n" +
"                <!-- first row //-->\n" +
"                <td style=\"width: 40%;\" valign=\"top\" id=\"leftMissionInfo\">\n" +
"                    <table id=\"leftMissionInfoTable\">\n" +
"                        <!-- left mission info table //-->\n" +
"                        <tr>\n" +
"                            <td colspan=\"2\"></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td colspan=\"2\" id=\"classification\">" + classification +"</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td colspan=\"2\"></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"label\">Mission #</td>\n" +
"                            <td class=\"data\" id=\"misisonNumber\">" + missionNumber + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"label\">FROM:</td>\n" +
"                            <td class=\"data\" id=\"leftFrom\">" + leftFrom + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"label\">To:</td>\n" +
"                            <td class=\"data\" id=\"leftTo\">" + leftTo+ "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"additionalText\" colspan=\"2\" id=\"leftAdditionaInfo\">\n" +
"                                <pre>\n" +
"" + leftAdditionalText +"\n" +
"</pre>\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                    </table>\n" +
"                    <!-- end left mission info table //-->\n" +
"                </td>\n" +
"                <td style=\"width: 60%;\" valign=\"top\">\n" +
"                    <table>\n" +
"                        <!-- right mission info table //-->\n" +
"                        <tr>\n" +
"                            <!-- cc and acc row //-->\n" +
"                            <td class=\"label\">CC -</td>\n" +
"                            <td class=\"data\" colspan=\"2\" id=\"cc\">" + cc + "</td>\n" +
"                            <td class=\"label\">ACC -</td>\n" +
"                            <td class=\"data\" colspan=\"2\" id=\"acc\">" + acc + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <!-- staging area row //-->\n" +
"                            <td class=\"label\">Staging Area -</td>\n" +
"                            <td class=\"data\" colspan=\"5\" id=\"stagingArea\">" + stagingArea + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <!-- from l/u sp //-->\n" +
"                            <td class=\"label\">From -</td>\n" +
"                            <td class=\"data\" id=\"rightFrom\">" + rightFrom + "</td>\n" +
"                            <td class=\"label\">L/U -</td>\n" +
"                            <td class=\"data\" id=\"fromLu\">" + fromLU + "</td>\n" +
"                            <td class=\"label\">SP -</td>\n" +
"                            <td class=\"data\" id=\"fromSP\">" + fromSP + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <!-- to l/u sp//-->\n" +
"                            <td class=\"label\">To -</td>\n" +
"                            <td class=\"data\" id=\"rightTo\">" + rightTo + "</td>\n" +
"                            <td class=\"label\">L/U -</td>\n" +
"                            <td class=\"data\" id=\"toLu\">" + toLU + "</td>\n" +
"                            <td class=\"label\">SP -</td>\n" +
"                            <td class=\"data\" id=\"toSP\">" + toSP + "</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <!-- frequency row //-->\n" +
"                            <td colspan=\"6\">\n" +
"                                <table id=\"freqTable\">\n" +
"                                    <!-- frequency table //-->\n" +
"                                    <tr>\n" +
"                                        <td class=\"label\" colspan=\"6\">Frequencys -</td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td class=\"label\">CH1:</td>\n" +
"                                        <td class=\"data\" id=\"ch1Name\">Internal Frequency</td>\n" +
"                                        <td class=\"data\" id=\"ch1Freq\">XX.XXX</td>\n" +
"                                        <td class=\"label\">CH2:</td>\n" +
"                                        <td class=\"data\" id=\"ch2Name\">Alternate/Eagle Main FSC:TOC</td>\n" +
"                                        <td class=\"data\" id=\"ch2Freq\">XX.XXX</td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td class=\"label\">CH3:</td>\n" +
"                                        <td class=\"data\" id=\"ch3Name\">P:</td>\n" +
"                                        <td class=\"data\" id=\"ch3Freq\">30.075 FM</td>\n" +
"                                        <td class=\"label\">CH4:</td>\n" +
"                                        <td class=\"data\" id=\"ch4Name\">S:</td>\n" +
"                                        <td class=\"data\" id=\"ch4Freq\">40.525 FM</td>\n" +
"                                    </tr>\n" +
"                                </table>\n" +
"                                <!-- end frequency table //-->\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"additionalText\" colspan=\"6\">\n" +
"                                <pre>\n" +
"Battle Spaces:\n" +
"              AP Hill TOC OPS Net:        CH 2: 30.075 FM\n" +
"              Ground to Air Net:          CH 5: 139.4625 VHF\n" +
"              Range Control AP Hill:      CH 3: XX.XXX FM\n" +
"</pre>\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                    </table>\n" +
"                    <!-- end right mission info table //-->\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr class=\"rows\">\n" +
"                <!-- third row //-->\n" +
"                <td colspan=\"2\">\n" +
"                    <table>\n" +
"                        <tr>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                            <td class=\"vehicle\"></td>\n" +
"                        </tr>\n" +
"                    </table>\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr class=\"rows\">\n" +
"                <!-- second row //-->\n" +
"                <td class=\"additionalText\" colspan=\"2\">Additional Text</td>\n" +
"            </tr>\n" +
"        </table>\n" +
"    </div>\n" +
"</body>\n" +
"\n" +
"</html>");
                
                Desktop.getDesktop().browse(f.toURI());
            }
        }catch(IOException ex){
        }
        
    }
    
}