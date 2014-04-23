package convoy.pdf;

import convoy.gui.VehicleGrid;
import convoy.objects.Radio;
import java.awt.Color;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to create the pdf. I creates the pdf using the pdf library
 * by grabbing the generated html and opening the pdf in the user's default pdf
 * application.
 * </p>
 */
public class GenerateHtml {

    /**
     * Default constructor
     */
    public GenerateHtml() {
    }

    public static void main(String[] args) {
        //TimeZone timezone = TimeZone.getTimeZone(TimeZone.getDefault().getID());
        //System.out.print((timezone.getOffset(Calendar.ZONE_OFFSET) / 3600000));
    }

    private String getlocale() {

        TimeZone timezone = TimeZone.getTimeZone(TimeZone.getDefault().getID());

        int localZone = (timezone.getOffset(Calendar.ZONE_OFFSET) / 3600000);

        //System.out.print(localZone);
        if (localZone == -12) {
            return "Y";
        }
        if (localZone == -11) {
            return "X";
        }
        if (localZone == -10) {
            return "W";
        }
        if (localZone == -9) {
            return "V";
        }
        if (localZone == -8) {
            return "U";
        }
        if (localZone == -7) {
            return "T";
        }
        if (localZone == -6) {
            return "S";
        }
        if (localZone == -5) {
            return "R";
        }
        if (localZone == -4) {
            return "Q";
        }
        if (localZone == -3) {
            return "P";
        }
        if (localZone == -2) {
            return "O";
        }
        if (localZone == -1) {
            return "N";
        }
        if (localZone == 0) {
            return "Z";
        }
        if (localZone == 1) {
            return "A";
        }
        if (localZone == 2) {
            return "B";
        }
        if (localZone == 3) {
            return "C";
        }
        if (localZone == 4) {
            return "D";
        }
        if (localZone == 5) {
            return "E";
        }
        if (localZone == 6) {
            return "F";
        }
        if (localZone == 7) {
            return "G";
        }
        if (localZone == 8) {
            return "H";
        }
        if (localZone == 9) {
            return "I";
        }
        if (localZone == 10) {
            return "K";
        }
        if (localZone == 11) {
            return "L";
        }
        if (localZone == 12) {
            return "M";
        } else {
            return "?";
        }
    }

    /**
     * <p>
     * This method is used to generate the HTML and CSS. It grabs all the
     * attribute from the convoy and adds them to the HTML file. The CSS is
     * embedded in the HTML file.
     * </p>
     *
     * @param watermark
     * @param classification
     * @param missionNumber
     * @param leftFrom
     * @param leftTo
     * @param leftAdditionalText
     * @param cc
     * @param acc
     * @param stagingArea
     * @param fromLU
     * @param toLU
     * @param fromSP
     * @param toSP
     * @param fromLUTime
     * @param toLUTime
     * @param fromSPTime
     * @param toSPTime
     * @param freqs
     * @param rightAdditionalText
     * @param additionalText
     * @param vehicleGrid
     */
    public void generateHtml(String watermark,
            int classification,
            String missionNumber,
            String leftFrom,
            String leftTo,
            String leftAdditionalText,
            String cc,
            String acc,
            String stagingArea,
            Date fromLU,
            Date toLU,
            Date fromSP,
            Date toSP,
            String fromLUTime,
            String toLUTime,
            String fromSPTime,
            String toSPTime,
            ArrayList<Radio> freqs,
            String rightAdditionalText,
            String additionalText,
            VehicleGrid vehicleGrid) {

        try {

            if (!"Z".equals(fromLUTime.substring(fromLUTime.length() - 1))) {
                fromLUTime = fromLUTime + getlocale();
            }

            if (!"Z".equals(toLUTime.substring(toLUTime.length() - 1))) {
                toLUTime = toLUTime + getlocale();
            }

            if (!"Z".equals(fromSPTime.substring(fromSPTime.length() - 1))) {
                fromSPTime = fromSPTime + getlocale();
            }

            if (!"Z".equals(toSPTime.substring(toSPTime.length() - 1))) {
                toSPTime = toSPTime + getlocale();
            }

            String xClassification = "";

            if (classification == 0) {
                xClassification = "FOR OFFICIAL USE ONLY";
            }
            if (classification == 1) {
                xClassification = "UNCLASSIFIED";
            }
            if (classification == 2) {
                xClassification = "CLASSIFIED";
            }
            if (classification == 3) {
                xClassification = "SECRET";
            }
            if (classification == 4) {
                xClassification = "TOP SECRET";
            }
            if (classification == 5) {
                xClassification = "CONFEDENTIAL";
            }

            String[] vehicles = new String[16];

            //System.out.print(rightAdditionalText.replace("<html>", "").replace("<head>", "").replace("<body>", "").replace("</html>", "").replace("</head>", "").replace("</body>", "").replace("\n", ""));
            for (int v = 0; v < vehicles.length; v++) {
                vehicles[v] = "                                     <table>\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td></td>\n"
                        + "                                            </tr>\n"
                        + "                                        </table>";
            }

            for (int i = 0; i < vehicleGrid.getVehiclePanelArray().size(); i++) {
                
                
                String passenger1 = "<td>" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger1() + "</td>\n";
                String passenger2 = "<td>" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger2() + "</td>\n";
                String passenger3 = "<td>" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger3() + "</td>\n";
                
                if(vehicleGrid.getVehiclePanelArray().get(i).getPassengerLabel1().getForeground() == Color.RED){
                    passenger1 = "<td class=\"red\">" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger1() + "</td>\n";
                }
                if(vehicleGrid.getVehiclePanelArray().get(i).getPassengerLabel2().getForeground() == Color.RED){
                    passenger2 = "<td class=\"red\">" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger1() + "</td>\n";
                }
                if(vehicleGrid.getVehiclePanelArray().get(i).getPassengerLabel3().getForeground() == Color.RED){
                    passenger3 = "<td class=\"red\">" + vehicleGrid.getVehiclePanelArray().get(i).getPassenger1() + "</td>\n";
                }
                
                
                vehicles[i] = "<table>\n"
                        + "                                            <tr>\n"
                        + "                                                <td class=\"driver\">" + vehicleGrid.getVehiclePanelArray().get(i).getDriverName() + "</td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + passenger1
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + passenger2
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + passenger3
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td><img src=\"" + "file:\\" + vehicleGrid.getVehiclePanelArray().get(i).getIconPath() + "\" alt=\"vehicle\" width=\"150\" /></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td><hr /></td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td>" + vehicleGrid.getVehiclePanelArray().get(i).getBumperNumber() + "</td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td>" + vehicleGrid.getVehiclePanelArray().get(i).getCallSign() + "</td>\n"
                        + "                                            </tr>\n"
                        + "\n"
                        + "                                            <tr>\n"
                        + "                                                <td>" + vehicleGrid.getVehiclePanelArray().get(i).getAdditonalInfo() + "</td>\n"
                        + "                                            </tr>\n"
                        + "                                        </table>";
            }

            String radio = "                           <tr>"
                    + "                             <td colspan=\"6\">"
                    + "                                <table id=\"freqTable\">\n"
                    + "                                    <!-- frequency table //-->\n"
                    + "                                    <tr>\n"
                    + "                                        <td class=\"label\"><strong>No Radio Frequencies</strong></td>\n"
                    + "                                    </tr>\n"
                    + "                                </table>\n"
                    + "                                <!-- end frequency table //-->\n"
                    + "                             </td>"
                    + "                         </tr>";

            if (!freqs.get(0).getName().equalsIgnoreCase("")) {
                radio = "                           <tr>"
                        + "                             <td colspan=\"6\">"
                        + "                                <table id=\"freqTable\">\n"
                        + "                                    <!-- frequency table //-->\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\" colspan=\"6\">Frequencys -</td>\n"
                        + "                                    </tr>\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\">CH1:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Name\">" + freqs.get(0).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Freq\">" + freqs.get(0).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                </table>\n"
                        + "                                <!-- end frequency table //-->\n"
                        + "                             </td>"
                        + "                         </tr>";
            }
            if (!freqs.get(1).getName().equalsIgnoreCase("")) {
                radio = "                           <tr>\n"
                        + "                            <!-- frequency row //-->\n"
                        + "                            <td colspan=\"6\">\n"
                        + "                                 <table id=\"freqTable\">\n"
                        + "                                    <!-- frequency table //-->\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\" colspan=\"6\">Frequencys -</td>\n"
                        + "                                    </tr>\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\">CH1:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Name\">" + freqs.get(0).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Freq\">" + freqs.get(0).getFreq() + "</td>\n"
                        + "                                        <td class=\"label\">CH2:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Name\">" + freqs.get(1).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Freq\">" + freqs.get(1).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                </table>\n"
                        + "                                <!-- end frequency table //-->\n"
                        + "                            </td>\n"
                        + "                        </tr>\n";
            }

            if (!freqs.get(2).getName().equalsIgnoreCase("")) {
                radio = "                        <tr>\n"
                        + "                            <!-- frequency row //-->\n"
                        + "                            <td colspan=\"6\">\n" + "                    <table id=\"freqTable\">\n"
                        + "                                    <!-- frequency table //-->\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\" colspan=\"6\">Frequencys -</td>\n"
                        + "                                    </tr>\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\">CH1:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Name\">" + freqs.get(0).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Freq\">" + freqs.get(0).getFreq() + "</td>\n"
                        + "                                        <td class=\"label\">CH2:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Name\">" + freqs.get(1).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Freq\">" + freqs.get(1).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                     <tr>\n"
                        + "                                        <td class=\"label\">CH3:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch3Name\">" + freqs.get(2).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch3Freq\">" + freqs.get(2).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                </table>\n"
                        + "                                <!-- end frequency table //-->\n" + "                            </td>\n"
                        + "                        </tr>\n";
            }

            if (!freqs.get(3).getName().equalsIgnoreCase("")) {
                radio
                        = "                        <tr>\n"
                        + "                            <!-- frequency row //-->\n"
                        + "                            <td colspan=\"6\">\n" + "                    <table id=\"freqTable\">\n"
                        + "                    <table id=\"freqTable\">\n"
                        + "                                    <!-- frequency table //-->\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\" colspan=\"6\">Frequencys -</td>\n"
                        + "                                    </tr>\n"
                        + "                                    <tr>\n"
                        + "                                        <td class=\"label\">CH1:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Name\">" + freqs.get(0).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch1Freq\">" + freqs.get(0).getFreq() + "</td>\n"
                        + "                                        <td class=\"label\">CH2:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Name\">" + freqs.get(1).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch2Freq\">" + freqs.get(1).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                     <tr>\n"
                        + "                                        <td class=\"label\">CH3:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch3Name\">" + freqs.get(2).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch3Freq\">" + freqs.get(2).getFreq() + "</td>\n"
                        + "                                        <td class=\"label\">CH4:</td>\n"
                        + "                                        <td class=\"data\" id=\"ch4Name\">" + freqs.get(3).getName() + "</td>\n"
                        + "                                        <td class=\"data\" id=\"ch4Freq\">" + freqs.get(3).getFreq() + "</td>\n"
                        + "                                    </tr>\n"
                        + "                                </table>\n"
                        + "                                <!-- end frequency table //-->\n" + "                            </td>\n"
                        + "                        </tr>\n";
            }

            if (rightAdditionalText.equalsIgnoreCase("") || rightAdditionalText.contains("Additional Information Goes Here")) {
                rightAdditionalText = "";
            } else {
                rightAdditionalText = "             <tr>\n"
                        + "                            <td class=\"additionalText\" colspan=\"6\">\n"
                        + "                                <pre>\n"
                        + rightAdditionalText.replace("<html>", "").replace("<head>", "").replace("<body>", "").replace("</html>", "").replace("</head>", "").replace("</body>", "")
                        + "                                 </pre>\n"
                        + "                            </td>\n"
                        + "                        </tr>\n";
            }

            if (leftAdditionalText.equalsIgnoreCase("") || leftAdditionalText.equalsIgnoreCase("Additional Information Goes Here")) {
                leftAdditionalText = "";
            } else {
                leftAdditionalText = "                        <tr>\n"
                        + "                                     <td class=\"additionalText\" colspan=\"3\" id=\"leftAdditionaInfo\">\n"
                        + "                                         <pre>\n"
                        + "" + leftAdditionalText + "\n"
                        + "                                         </pre>\n"
                        + "                                     </td>\n"
                        + "                                 </tr>\n";
            }

            if (additionalText.equalsIgnoreCase("Additional Information Goes Here") || additionalText.equalsIgnoreCase("Additional Information Goes Here")) {
                additionalText = "";
            } else {
                additionalText = "            <tr class=\"rows\">\n"
                        + "                <!-- second row //-->\n"
                        + "                <td class=\"additionalText\" colspan=\"3\">" + additionalText + "</td>\n"
                        + "            </tr>\n";
            }

            String classificationColor;

            if (xClassification.equalsIgnoreCase("SECRET") || xClassification.equalsIgnoreCase("TOP SECRET") || xClassification.equalsIgnoreCase("CONFEDIENTAL")) {
                classificationColor = "red";
            } else {
                classificationColor = "black";
            }

            try {
                File f = null;
                try {
                    f = new File(getProgramPath() + "\\conx\\html\\convoy.html");

                    //System.out.print(f);
                } catch (UnsupportedEncodingException ex) {

                } finally {

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                        bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n"
                                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                                + "\n"
                                + "<head>\n"
                                + "    <title></title>\n"
                                + "    <style type=\"text/css\">\n"
                                + "        body {\n"
                                + "            //background-color: rgb(194, 178, 128);\n"
                                + "        }\n"
                                + "        div,\n"
                                + "        table {\n"
                                + "            width: 100%;\n"
                                + "            //border: 1px solid #000;\n"
                                + "            //height: 100%;\n"
                                + "            font-size: 14pt;\n"
                                + "        }\n"
                                + "        td {\n"
                                + "            //border: 1px solid #000;\n"
                                + "            background-color: white;\n"
                                + "        }\n"
                                + "        .label {\n"
                                + "            font-weight: bold;\n"
                                + "            font-family: capture;\n"
                                + "            height: 30px;\n"
                                + "        }\n"
                                + "        .leftLabel {\n"
                                + "            font-weight: bold;\n"
                                + "            font-family: capture;\n"
                                + "            text-align: center;\n"
                                + "            height: 57px;\n"
                                + "        }\n"
                                + "        .data {\n"
                                + "             font-weight: normal;\n"
                                + "             text-align: left;\n"
                                + "        }\n"
                                + "        .leftData {\n"
                                + "             font-weight: normal;\n"
                                + "             text-align: left;\n"
                                + "        }\n"
                                + "        #freqTable {\n"
                                + "            border: 0;\n"
                                + "        }\n"
                                + "        .rows {\n"
                                + "            border: red solid 1px;\n"
                                + "            height: 33%;\n"
                                + "        }\n"
                                + "        .vehicle td{\n"
                                + "            //height: 250px;\n"
                                + "            text-align: center;\n"
                                + "            //border: 1px solid black;\n"
                                + "            vertical-align: bottom;\n"
                                + "        }\n"
                                + "        #leftMissionInfo {\n"
                                + "            font-size: 18pt;\n"
                                + "            //border-right: 5px solid red;\n"
                                + "            width: 40%;\n"
                                + "            //table-layout: fixed;\n"
                                + "        }\n"
                                + "        .additionalText {\n"
                                + "            height: 100px;\n"
                                + "        }\n"
                                + "        #unitPatch img {\n"
                                + "            width: 202px;\n"
                                + "            height: 172px;\n"
                                + "        }\n"
                                + "        .redBorder {\n"
                                + "            border-top: red solid 5px;\n"
                                + "            border-bottom: red solid 5px;\n"
                                + "            padding-top: 10px;\n"
                                + "            padding-bottom: 10px;\n"
                                + "        }\n"
                                + "        #classification{"
                                + "              text-align: center;"
                                + "              font-weight: bold;"
                                + "              font-size: 24pt;"
                                + "              color: " + classificationColor + ";"
                                + "         }\n"
                                + "        .driver{"
                                + "             color: green;"
                                + "         }\n"
                                + "        .midBorder {\n"
                                + "            border-top: red solid 5px;\n"
                                + "        }\n"
                                + "        .picCell{"
                                + "             max-width:100px;"
                                + "             width: 100px;"
                                + "             //max-height:100px;"
                                + "             //height: 100px;"
                                + "         }"
                                + "        .3rdOfPicHeight{"
                                + "             height: 56px"
                                + "         }"
                                + "          .vehicle{\n"
                                + "            height: 200px;\n"
                                + "            border: 1px solid black;\n width: 100px;\n"
                                + "             max-width: 100px;"
                                + "             width: 100px;"
                                + "        }\n"
                                + "        .red{\n"
                                + "            color: red;"
                                + "        }\n"
                                + "    </style>\n"
                                + "</head>\n"
                                + "\n"
                                + "<body>\n"
                                + "    <div>\n"
                                + "        <table>\n"
                                + "            <!-- main table //-->\n"
                                + "            <tr class=\"rows\">\n"
                                + "                <!-- first row //-->\n"
                                + "                <td style=\"width: 40%;\" valign=\"top\" id=\"leftMissionInfo\">\n"
                                + "                    <table id=\"leftMissionInfoTable\">\n"
                                + "                        <!-- left mission info table //-->\n"
                                + "                        <tr>\n"
                                + "                            <td colspan=\"3\" id=\"classification\">" + xClassification + "</td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"picCell\" colspan=\"1\" rowspan=\"4\" id=\"unitPatch\"><img src=\"" + "file:\\" + watermark + "\" alt=\"unitPatch\"/></td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"leftLabel\">Mission #</td>\n"
                                + "                            <td class=\"leftData\" id=\"misisonNumber\">" + missionNumber + "</td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"leftLabel\">Start Point:</td>\n"
                                + "                            <td class=\"leftData\" id=\"leftFrom\">" + leftFrom + "</td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"leftLabel\">Rally Point:</td>\n"
                                + "                            <td class=\"leftData\" id=\"leftTo\">" + leftTo + "</td>\n"
                                + "                        </tr>\n"
                                + leftAdditionalText
                                + "                    </table>\n"
                                + "                    <!-- end left mission info table //-->\n"
                                + "                </td>\n"
                                + "                <td style=\"width: 60%;\" valign=\"top\">\n"
                                + "                    <table>\n"
                                + "                        <!-- right mission info table //-->\n"
                                + "                        <tr>\n"
                                + "                            <!-- cc and acc row //-->\n"
                                + "                            <td class=\"label\">CC:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + cc + "</span></td>\n"
                                + "                            <td class=\"label\">ACC:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + acc + "</span></td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <!-- staging area row //-->\n"
                                + "                            <td class=\"label\" colspan=\"2\">Staging Area:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + stagingArea + "</span></td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <!-- from l/u sp //-->\n"
                                + "                            <td class=\"label\">Start Point Linkup Time:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + fromLU.toString().substring(8, 10) + fromLUTime.replace(":", "") + fromLU.toString().substring(4, 7).toUpperCase() + new SimpleDateFormat("yy").format(fromLU) + "</span></td>\n"
                                + "                            <td class=\"label\">Start Point SP Time:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + fromSP.toString().substring(8, 10) + fromSPTime.replace(":", "") + fromSP.toString().substring(4, 7).toUpperCase() + new SimpleDateFormat("yy").format(fromSP) + "</span></td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                            <!-- to l/u sp//-->\n"
                                + "                            <td class=\"label\">Rally Point Linkup Time:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + toLU.toString().substring(8, 10) + toLUTime.replace(":", "") + toLU.toString().substring(4, 7).toUpperCase() + new SimpleDateFormat("yy").format(toLU) + "</span></td>\n"
                                + "                            <td class=\"label\">Rally Point SP Time:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"data\">" + toSP.toString().substring(8, 10) + toSPTime.replace(":", "") + toSP.toString().substring(4, 7).toUpperCase() + new SimpleDateFormat("yy").format(toSP) + "</span></td>\n"
                                + "                        </tr>\n"
                                + radio
                                + rightAdditionalText
                                + "                    </table>\n"
                                + "                    <!-- end right mission info table //-->\n"
                                + "                </td>\n"
                                + "            </tr>\n"
                                + "            <tr class=\"rows\">\n"
                                + "                <!-- third row //-->\n"
                                + "                <td colspan=\"2\">\n"
                                + "                    <table class=\"redBorder\">\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[0]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[1]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[2]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[3]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[4]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[5]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[6]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[7]
                                + "</td>\n"
                                + "                        </tr>\n"
                                + "                        <tr>\n"
                                + "                             <td class=\"midBorder\" colspan=\"8\"></td>\n"
                                + "                         </tr>\n"
                                + "                        <tr>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[8]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[9]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[10]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[11]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[12]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[13]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[14]
                                + "</td>\n"
                                + "                            <td class=\"vehicle\">"
                                + vehicles[15]
                                + "                             </td>\n"
                                + "                        </tr>\n"
                                + "                    </table>\n"
                                + "                </td>\n"
                                + "            </tr>\n"
                                + additionalText
                                + "        </table>\n"
                                + "    </div>\n"
                                + "</body>\n"
                                + "\n"
                                + "</html>");

                    }

                    //Desktop.getDesktop().browse(f.toURI()); open html file in default browser.
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }
}
