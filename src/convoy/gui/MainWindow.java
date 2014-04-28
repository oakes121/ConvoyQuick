package convoy.gui;

import static convoy.gui.LeftMissionInfoPanel.getProgramPath;
import convoy.loadsave.Load;
import convoy.loadsave.Save;
import convoy.objects.Mission;
import convoy.pdf.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to create the Main Window.
 * </p>
 */
public final class MainWindow extends javax.swing.JFrame {

    //private static final MainWindow frame = new MainWindow();
    private String missionNumberText; //mission number used to save convoy file
    private SplashScreen mainMenu = new SplashScreen();
    private ArrayList<VehicleGrid> vehicleGrids = new ArrayList<>();
    private int vehicleGridCount = 0;
    private int currentVehicleGrid = 0;

    private static boolean cc = false;
    private static boolean acc = false;

    public static boolean getCC() {
        return cc;
    }

    public static boolean getACC() {
        return acc;
    }

    public static void setCC(boolean xCC) {
        cc = xCC;
    }

    public static void setACC(boolean xACC) {
        acc = xACC;
    }

    /**
     * <p>
     * Creates new form mainWindow Used for default when no data needs to be
     * loadProjected
     * </p>
     */
    public MainWindow() {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // added
            this.setTitle("Convoy Quick - Convoy Documentation Creator To Help Save Lives");
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
            
                       
            
            vehicleGrids.add(vehicleGrid1);
            
            vehicleGrid1.setMainWindow(this);
            missionNumberPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            additionalInfoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            
            this.leftMissionInfoPanel1.setImagePath(getProgramPath() + "\\conx\\images\\unit patches\\Maryland.png");
            
            Image img = ImageIO.read(new File(getProgramPath() + "\\conx\\images\\unit patches\\Maryland.png"));
            
            Image finalImage = img.getScaledInstance(196, 162, java.awt.Image.SCALE_SMOOTH); // getScaledInstance(width, hieght, algorithm)
            ImageIcon icon = new ImageIcon(finalImage);
            this.leftMissionInfoPanel1.setIcon(icon);
            
            //this.leftMissionInfoPanel1.setAdditionalText("Additional Text Goes Here");
            this.rightMissionInfoPanel2.setAddtionalText("Additional Information Goes Here");
            
            this.rightArrow.setVisible(false);
            this.leftArrow.setVisible(false);
            
            deleteCurrentVehiclePage.setEnabled(false);
            
            final JScrollPane scroll = new JScrollPane(picturePanel2);
            add(scroll);
            
            revalidate();
            repaint();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Creates new form mainWindow Used when loadProjecting a previously saved
     * convoy file
     * </p>
     *
     * @param missionNumber
     * @param classification
     * @param stagingArea
     * @param acc
     * @param cc
     * @param fromLinkUpDate
     * @param fromSPDate
     * @param leftFrom
     * @param leftTo
     * @param toLinkUpDate
     * @param toSPDate
     * @param leftAdditionalText
     * @param rightAdditionalText
     * @param additionalText
     * @param unitPatch
     */
    public MainWindow(String missionNumber,
            int classification,
            String stagingArea,
            String acc,
            String cc,
            Date fromLinkUpDate,
            Date fromSPDate,
            String leftFrom,
            String leftTo,
            Date toLinkUpDate,
            Date toSPDate,
            String startLinkUpTime,
            String startSPTime,
            String rallyLinkUpTime,
            String rallySPTime,
            int startLinkUpTimeZone,
            int startSPTimeZone,
            int rallyLinkUpTimeZone,
            int rallySPTimeZone,
            String leftAdditionalText,
            String rightAdditionalText,
            String additionalText,
            String unitPatch) {
        try {
            initComponents();
            
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // added
            this.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
            
            vehicleGrids.add(vehicleGrid1);
            
            missionNumberPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            additionalInfoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            
            this.leftMissionInfoPanel1.setMissionNumber(missionNumber);
            
            this.leftMissionInfoPanel1.setClassification(classification);
            
            this.leftMissionInfoPanel1.setFrom(leftFrom);
            this.leftMissionInfoPanel1.setTo(leftTo);
            
            this.rightMissionInfoPanel2.setCC(cc);
            this.rightMissionInfoPanel2.setACC(acc);
            
            this.rightMissionInfoPanel2.setStagingArea(stagingArea);
            
            this.rightMissionInfoPanel2.setFromLU(fromLinkUpDate);
            this.rightMissionInfoPanel2.setFromSP(fromSPDate);
            this.rightMissionInfoPanel2.setToLU(toLinkUpDate);
            this.rightMissionInfoPanel2.setToSP(toSPDate);
            
            this.leftMissionInfoPanel1.setAdditionalText(leftAdditionalText);
            this.rightMissionInfoPanel2.setAddtionalText(rightAdditionalText);
            this.additionalTextPanel1.setAdditionalText(additionalText);
            
            this.rightMissionInfoPanel2.setStartLinkUpTime(startLinkUpTime);
            this.rightMissionInfoPanel2.setStartSPTime(startSPTime);
            this.rightMissionInfoPanel2.setRallyLinkUpTime(rallyLinkUpTime);
            this.rightMissionInfoPanel2.setRallySPTime(rallySPTime);
            
            this.rightMissionInfoPanel2.setStartLinkupTimeZone(startLinkUpTimeZone);
            this.rightMissionInfoPanel2.setStartSPTimZone(startSPTimeZone);
            this.rightMissionInfoPanel2.setRallyLinkUpTimeZone(rallyLinkUpTimeZone);
            this.rightMissionInfoPanel2.setRallSPTimeZone(rallySPTimeZone);
            
            //Image img = new ImageIcon(unitPatch).getImage().getScaledInstance(202, 168, java.awt.Image.SCALE_SMOOTH);
            
            this.leftMissionInfoPanel1.setImagePath(unitPatch);
            
            Image img = ImageIO.read(new File(unitPatch));
            
            if (img != null) {
                Image finalImage = img.getScaledInstance(196, 162, java.awt.Image.SCALE_SMOOTH); // getScaledInstance(width, hieght, algorithm)
                ImageIcon icon = new ImageIcon(finalImage);
                this.leftMissionInfoPanel1.setIcon(icon);
            }
            
            //this.leftMissionInfoPanel1.setIcon(new ImageIcon(img));
            
            this.rightArrow.setVisible(false);
            this.leftArrow.setVisible(false);
            
            final JScrollPane scroll = new JScrollPane(picturePanel2);
            add(scroll);
            
            revalidate();
            repaint();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VehicleGrid getVehicleGrid() {
        return vehicleGrid1;
    }

    public LeftMissionInfoPanel getLeftMissionInfoPanel() {
        return this.leftMissionInfoPanel1;
    }

    public RightMissionInfoPanel getRightMissionInfoPanel() {
        return this.rightMissionInfoPanel2;
    }

    /**
     * displays and set the attribute and properties of the main window frame
     */
    public void display() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // added 
        setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
        setVisible(true);
        toFront();
        revalidate();
        repaint();

    }

    public void reDrawVehicleGrid(VehicleGrid vg) {

        javax.swing.GroupLayout picturePanel2Layout = new javax.swing.GroupLayout(picturePanel2);

        picturePanel2.setLayout(picturePanel2Layout);
        picturePanel2Layout.setHorizontalGroup(
                picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(missionNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                        .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(additionalInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(vg, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                                                        .addGap(0, 0, 0)
                                                                        .addComponent(rightArrow)))))
                                        .addContainerGap())))
        );
        picturePanel2Layout.setVerticalGroup(
                picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addComponent(missionNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                        .addComponent(rightArrow)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE))
                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(vg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                .addGroup(picturePanel2Layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(additionalInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //getContentPane().add(picturePanel2);
    }

    public void newVehicleGrid() {
        vehicleGrids.add(new VehicleGrid());
        vehicleGridCount++;
        currentVehicleGrid++;
        vehicleGrids.get(currentVehicleGrid).setMainWindow(this);
    }

    public void showFirstVehicleGrid() {
        currentVehicleGrid = 0;
        this.reDrawVehicleGrid(vehicleGrids.get(0));

        updateArrows();
    }

    private void updateArrows() {

        hideLeftArrow();
        hideRightArrow();

        if (currentVehicleGrid == 0) {
            deleteCurrentVehiclePage.setEnabled(false);
        } else {
            deleteCurrentVehiclePage.setEnabled(true);
        }

        if (currentVehicleGrid == vehicleGridCount) {
            if (vehicleGridCount > 0) {
                showLeftArrow();
            }

            if (vehicleGrids.get(currentVehicleGrid).getVehicleCount() == 16) {
                showRightArrow();
            }
        }

        if (currentVehicleGrid < vehicleGridCount) {
            if (currentVehicleGrid == 0) {
                showRightArrow();
            }

            if (currentVehicleGrid > 0) {
                showRightArrow();
                showLeftArrow();

            }
        }

        revalidate();
        repaint();
    }

    public ArrayList<VehicleGrid> getVehicleGrids() {
        return vehicleGrids;
    }

    public void setVehicleGrids(ArrayList<VehicleGrid> vgs) {

        picturePanel2.remove(vehicleGrids.get(currentVehicleGrid));
        vehicleGrids = vgs;

        vehicleGridCount = vgs.size();
        currentVehicleGrid = 0;
        reDrawVehicleGrid(vehicleGrids.get(vehicleGridCount));

        //vehicleGrids.get(currentVehicleGrid).setMainWindow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        picturePanel2 = new convoy.gui.PicturePanel("");
        missionNumberPanel = new javax.swing.JPanel();
        leftMissionInfoPanel1 = new convoy.gui.LeftMissionInfoPanel();
        rightMissionInfoPanel2 = new convoy.gui.RightMissionInfoPanel();
        additionalInfoPanel = new javax.swing.JPanel();
        additionalTextPanel1 = new convoy.gui.AdditionalTextPanel();
        vehicleGrid1 = new convoy.gui.VehicleGrid();
        jPanel1 = new javax.swing.JPanel();
        rightArrow = new javax.swing.JLabel();
        leftArrow = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        finalizeMenu = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();
        templatesMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        wateMarkMenu = new javax.swing.JMenuItem();
        deleteCurrentVehiclePage = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1350, 2147483647));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 906));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        picturePanel2.setBackground(new java.awt.Color(194, 178, 128));

        missionNumberPanel.setBackground(new java.awt.Color(194, 178, 128));
        missionNumberPanel.setPreferredSize(new java.awt.Dimension(1440, 325));
        missionNumberPanel.setLayout(new javax.swing.BoxLayout(missionNumberPanel, javax.swing.BoxLayout.LINE_AXIS));

        leftMissionInfoPanel1.setPreferredSize(new java.awt.Dimension(650, 400));
        missionNumberPanel.add(leftMissionInfoPanel1);
        missionNumberPanel.add(rightMissionInfoPanel2);

        additionalInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        additionalInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        additionalInfoPanel.setLayout(new java.awt.BorderLayout());
        additionalInfoPanel.add(additionalTextPanel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(194, 178, 128));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/Aiga_rightarrow_inv.gif"))); // NOI18N
        rightArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rightArrowMousePressed(evt);
            }
        });

        leftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/Aiga_leftarrow_inv.gif"))); // NOI18N
        leftArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftArrowMousePressed(evt);
            }
        });

        javax.swing.GroupLayout picturePanel2Layout = new javax.swing.GroupLayout(picturePanel2);
        picturePanel2.setLayout(picturePanel2Layout);
        picturePanel2Layout.setHorizontalGroup(
            picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picturePanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(missionNumberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                    .addComponent(additionalInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(picturePanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picturePanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vehicleGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        picturePanel2Layout.setVerticalGroup(
            picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picturePanel2Layout.createSequentialGroup()
                .addComponent(missionNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(picturePanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(additionalInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(picturePanel2);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText("<html> <strong>File</strong> </html>");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("<html> <strong>New</strong> </html>");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadMenuItem.setText("<html><strong>Load</strong></html>");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("<html><strong>Save</strong></html>");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        finalizeMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        finalizeMenu.setText("<html><strong>Export to PDF</strong></html>");
        finalizeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeMenuActionPerformed(evt);
            }
        });
        fileMenu.add(finalizeMenu);

        printMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenuItem.setText("<html><strong>Print</strong></html>");
        printMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(printMenuItem);

        templatesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        templatesMenuItem.setText("<html><strong>Templates</strong></html>");
        templatesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templatesMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(templatesMenuItem);

        exitMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("<html> <strong>Edit</strong> </html>");

        wateMarkMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        wateMarkMenu.setText("<html><strong>Unit Patch</strong></html>");
        wateMarkMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wateMarkMenuActionPerformed(evt);
            }
        });
        editMenu.add(wateMarkMenu);

        deleteCurrentVehiclePage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        deleteCurrentVehiclePage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteCurrentVehiclePage.setText("Delete Current Vehicle Grid");
        deleteCurrentVehiclePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCurrentVehiclePageActionPerformed(evt);
            }
        });
        editMenu.add(deleteCurrentVehiclePage);

        menuBar.add(editMenu);

        helpMenu.setText("<html>\n<strong>Help</strong>\n</html>");

        helpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        helpMenuItem.setText("<html><strong>Help</strong></html>");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setText("<html><strong>About</strong></html>");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * create a new blank main window window form
     *
     * @param evt click file -> new menu item
     */
    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new convoy?\nAll unsaved data will be lost!", "New Convoy?", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            mainMenu.setMainWindow(new MainWindow());
            mainMenu.getMainWindow().display();
        }
    }//GEN-LAST:event_newMenuItemActionPerformed

    /**
     * <p>
     * Loads a previously saved convoy. The user selects a convoy file to be
     * loadProjected. The convoy file must have the file extension .conx, After
     * the user selects the convoy file a new main window frame is displayed
     * with the selected convoy file loadProjected.
     * </p>
     *
     * @param evt click file -> loadProject menu item
     */
    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        try {
            
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to load a convoy?\n All unsaved data will be lost.", "Load Convoy?", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                Load load = new Load();
                load.loadProject();
                if (load.getIsLoaded()) {
                    setVisible(false);
                }
            }
        } catch (HeadlessException ex) {

        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_loadMenuItemActionPerformed
    /**
     * Displays the about information dialog pop up
     *
     * @param evt click help -> about menu item
     */
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutWindow g = new AboutWindow();
       URL iconURL = getClass().getResource("/convoy/resources/images/humveeIcon.png");
       ImageIcon icon = new ImageIcon(iconURL);
       g.setIconImage(icon.getImage());
        g.setLocationRelativeTo( null );
        g.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**
     * Displays the help information dialog pop up
     *
     * @param evt click help -> help menu item
     */
    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        HelpWindow g = new HelpWindow();
       URL iconURL = getClass().getResource("/convoy/resources/images/humveeIcon.png");
       ImageIcon icon = new ImageIcon(iconURL);
       g.setIconImage(icon.getImage());
        g.setLocationRelativeTo( null );
        g.setVisible(true);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    /**
     * <p>
     * Finalizes the convoy. Prompts the user for the location to store the pdf.
     * Creates the pdf in the desired location. If user doesn't provide a file
     * name the file will be stored as Untitled.pdf.
     * </p>
     *
     * @param evt click file -> finalize menu item
     */
    private void finalizeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizeMenuActionPerformed
        if ("".equals(this.leftMissionInfoPanel1.getMissionNumber())) {
            JOptionPane.showMessageDialog(this, "Please enter a Mission Number.");
        } else {
            Mission mission;
            mission = Mission.getInstance(this.leftMissionInfoPanel1.getMissionNumber(),
                    this.rightMissionInfoPanel2.getStagingArea(),
                    this.leftMissionInfoPanel1.getTo(),
                    //this.rightMissionInfoPanel2.getTo(),
                    this.leftMissionInfoPanel1.getFrom(),
                    //this.rightMissionInfoPanel2.getFrom(),
                    this.rightMissionInfoPanel2.getCC(),
                    this.rightMissionInfoPanel2.getACC(),
                    this.rightMissionInfoPanel2.getFromLU(),
                    this.rightMissionInfoPanel2.getFromSP(),
                    this.rightMissionInfoPanel2.getToLU(),
                    this.rightMissionInfoPanel2.getToSP(),
                    this.rightMissionInfoPanel2.getStartLinkUpTime(),
                    this.rightMissionInfoPanel2.getStartSPTime(),
                    this.rightMissionInfoPanel2.getRallyLinkUpTime(),
                    this.rightMissionInfoPanel2.getRallySPTime(),
                    this.rightMissionInfoPanel2.getStartLinkupTimeZone(),
                    this.rightMissionInfoPanel2.getStartSPTimZone(),
                    this.rightMissionInfoPanel2.getRallyLinkUpTimeZone(),
                    this.rightMissionInfoPanel2.getRallSPTimeZone(),
                    this.leftMissionInfoPanel1.getClassification(),
                    this.leftMissionInfoPanel1.getAdditionalText(),
                    this.rightMissionInfoPanel2.getAdditionalText(),
                    this.additionalTextPanel1.getAdditionalText(),
                    this.leftMissionInfoPanel1.getImagePath(),
                    this.rightMissionInfoPanel2.getFreqGrid().getFreqs()
            );
            try {
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                Save sf = new Save(mission);
                sf.save();
            } catch (Exception ex) {
                //ex.printStackTrace();
            } finally {
                this.setCursor(Cursor.getDefaultCursor());
            }

            if (this.vehicleGrids.get(0).getVehicleCount() >= 2) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to export the convoy?", "Export Convoy?", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {

                    JFileChooser chooser = new JFileChooser();
                    chooser.setAcceptAllFileFilterUsed(false);
                    chooser.addChoosableFileFilter((new FileNameExtensionFilter("PDF Files", "pdf")));

                    missionNumberText = this.leftMissionInfoPanel1.getMissionNumber();

                    if (missionNumberText.equalsIgnoreCase("")) {
                        missionNumberText = "Untitled";
                    }

                    chooser.setSelectedFile(new File(missionNumberText));
                    chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\My Documents"));

                    int option = chooser.showSaveDialog(null);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        try {
                            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                                
                            for (VehicleGrid vehicleGrid : vehicleGrids) {
                                GenerateHtml gh = new GenerateHtml();
                                gh.generateHtml(this.leftMissionInfoPanel1.getImagePath(),
                                        this.leftMissionInfoPanel1.getClassification(),
                                        this.leftMissionInfoPanel1.getMissionNumber(),
                                        this.leftMissionInfoPanel1.getFrom(),
                                        this.leftMissionInfoPanel1.getTo(),
                                        this.leftMissionInfoPanel1.getAdditionalText(),
                                        this.rightMissionInfoPanel2.getCC(),
                                        this.rightMissionInfoPanel2.getACC(),
                                        this.rightMissionInfoPanel2.getStagingArea(),
                                        this.rightMissionInfoPanel2.getFromLU(),
                                        this.rightMissionInfoPanel2.getToLU(),
                                        this.rightMissionInfoPanel2.getFromSP(),
                                        this.rightMissionInfoPanel2.getToSP(),
                                        this.rightMissionInfoPanel2.getStartLinkUpTime(),
                                        this.rightMissionInfoPanel2.getStartSPTime(),
                                        this.rightMissionInfoPanel2.getRallyLinkUpTime(),
                                        this.rightMissionInfoPanel2.getRallySPTime(),
                                        this.rightMissionInfoPanel2.getFreqGrid().getFreqs(),
                                        this.rightMissionInfoPanel2.getAdditionalText(),
                                        this.additionalTextPanel1.getAdditionalText(),
                                        vehicleGrid);
                                Create cp = new Create(chooser.getSelectedFile().getPath());
                                cp.createPDF();
                            }

                        } catch (Exception ex) {
                        } finally {
                            this.setCursor(Cursor.getDefaultCursor());
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "You need to add at least 2 vehicles in order to Export the convoy!");
            }
        }
    }//GEN-LAST:event_finalizeMenuActionPerformed

    private static void copyFile(File source, File dest) throws IOException {

        Files.copy(source.toPath(), dest.toPath());

    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

    /**
     * <p>
     * Sets the unit patch image for the convoy. User selects an image file from
     * the desired directory. The file extensions can only be .jpg, .jpeg, .png,
     * .gif. The file is resized and the location of the file is stored.
     * </p>
     *
     * @param evt click edit -> unit patch menu item
     */
    private void wateMarkMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wateMarkMenuActionPerformed
        try {

            FileDialog loadFile = null;
            loadFile = new FileDialog(loadFile, "Choose an Image", FileDialog.LOAD);
            loadFile.setDirectory(getProgramPath() + "\\conx\\images\\unit patches\\");
            loadFile.setFile("*.jpg;*.jpeg;*.png;*.gif");
            loadFile.setVisible(true);
            try {
                File file = new File(loadFile.getFile());
                if (file.exists() || file != null) {
                    URL url = new URL("file:\\" + loadFile.getDirectory() + file);

                    copyFile(new File(loadFile.getDirectory() + file), new File(getProgramPath() + "\\conx\\images\\unit patches\\" + file));
                    this.leftMissionInfoPanel1.setImagePath(getProgramPath() + "\\conx\\images\\unit patches\\" + file);

                    try {
                        Image img = ImageIO.read(url);
                        Image finalImage = img.getScaledInstance(196, 162, java.awt.Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(finalImage);
                        this.leftMissionInfoPanel1.setIcon(icon);
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(AddVehiclePopUp.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                }
            } catch (IOException ex) {

            }
        } catch (UnsupportedEncodingException ex) {

        }

    }//GEN-LAST:event_wateMarkMenuActionPerformed

    /**
     * <p>
     * Does the same as the finalize menu item does execpt this methiod will
     * open the pdf in the default pdf application opener and open that
     * applications print dialog.
     * </p>
     *
     * @param evt click file -> print menu item
     */
    private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMenuItemActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to print the convoy?", "Print Convoy?", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.addChoosableFileFilter((new FileNameExtensionFilter("PDF Files", "pdf")));

            missionNumberText = this.leftMissionInfoPanel1.getMissionNumber();

            if (missionNumberText.equalsIgnoreCase("")) {
                missionNumberText = "Untitled";
            }

            chooser.setSelectedFile(new File(missionNumberText));
            chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\My Documents"));

            int option = chooser.showSaveDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                    GenerateHtml gh = new GenerateHtml();

                    gh.generateHtml(
                            this.leftMissionInfoPanel1.getImagePath(),
                            this.leftMissionInfoPanel1.getClassification(),
                            this.leftMissionInfoPanel1.getMissionNumber(),
                            this.leftMissionInfoPanel1.getFrom(),
                            this.leftMissionInfoPanel1.getTo(),
                            this.leftMissionInfoPanel1.getAdditionalText(),
                            this.rightMissionInfoPanel2.getCC(),
                            this.rightMissionInfoPanel2.getACC(),
                            this.rightMissionInfoPanel2.getStagingArea(),
                            this.rightMissionInfoPanel2.getFromLU(),
                            this.rightMissionInfoPanel2.getToLU(),
                            this.rightMissionInfoPanel2.getFromSP(),
                            this.rightMissionInfoPanel2.getToSP(),
                            this.rightMissionInfoPanel2.getStartLinkUpTime(),
                            this.rightMissionInfoPanel2.getStartSPTime(),
                            this.rightMissionInfoPanel2.getRallyLinkUpTime(),
                            this.rightMissionInfoPanel2.getRallySPTime(),
                            this.rightMissionInfoPanel2.getFreqGrid().getFreqs(),
                            this.rightMissionInfoPanel2.getAdditionalText(),
                            this.additionalTextPanel1.getAdditionalText(),
                            this.vehicleGrids.get(0)
                    );

                    Create cp = new Create(chooser.getSelectedFile().getPath());
                    cp.createPDFPrint();

                } catch (Exception ex) {
                } finally {
                    try {
                        this.setCursor(Cursor.getDefaultCursor());
                        Print p = new Print();
                        p.print(chooser.getSelectedFile().getPath());
                    } catch (Exception ex) {
                        this.setCursor(Cursor.getDefaultCursor());
                        Print p = new Print();
                        p.print(chooser.getSelectedFile().getPath());
                    }
                }
            }
        }
    }//GEN-LAST:event_printMenuItemActionPerformed

    /**
     * <p>
     * Saves the convoy. Creates a file with the .conx extension and with a
     * filename of the mission number. The file stores the byte code of all the
     * attributes of the convoy.
     * </p>
     *
     * @param evt click file -> save menu item
     */
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        Mission mission;
        mission = Mission.getInstance(this.leftMissionInfoPanel1.getMissionNumber(),
                this.rightMissionInfoPanel2.getStagingArea(),
                this.leftMissionInfoPanel1.getTo(),
                //this.rightMissionInfoPanel2.getTo(),
                this.leftMissionInfoPanel1.getFrom(),
                //this.rightMissionInfoPanel2.getFrom(),
                this.rightMissionInfoPanel2.getCC(),
                this.rightMissionInfoPanel2.getACC(),
                this.rightMissionInfoPanel2.getFromLU(),
                this.rightMissionInfoPanel2.getFromSP(),
                this.rightMissionInfoPanel2.getToLU(),
                this.rightMissionInfoPanel2.getToSP(),
                this.rightMissionInfoPanel2.getStartLinkUpTime(),
                this.rightMissionInfoPanel2.getStartSPTime(),
                this.rightMissionInfoPanel2.getRallyLinkUpTime(),
                this.rightMissionInfoPanel2.getRallySPTime(),
                this.rightMissionInfoPanel2.getStartLinkupTimeZone(),
                this.rightMissionInfoPanel2.getStartSPTimZone(),
                this.rightMissionInfoPanel2.getRallyLinkUpTimeZone(),
                this.rightMissionInfoPanel2.getRallSPTimeZone(),
                this.leftMissionInfoPanel1.getClassification(),
                this.leftMissionInfoPanel1.getAdditionalText(),
                this.rightMissionInfoPanel2.getAdditionalText(),
                this.additionalTextPanel1.getAdditionalText(),
                this.leftMissionInfoPanel1.getImagePath(),
                this.rightMissionInfoPanel2.getFreqGrid().getFreqs()
        );
        
        
        
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Save sf = new Save(mission);
            sf.save();
        } catch (Exception ex) {
            //ex.printStackTrace();
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }


    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?\n All unsaved data will be lost.", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void rightArrowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightArrowMousePressed
        // TODO add your handling code here:

        if (currentVehicleGrid == vehicleGridCount) {
            picturePanel2.remove(vehicleGrids.get(currentVehicleGrid));
            newVehicleGrid();
            reDrawVehicleGrid(vehicleGrids.get(vehicleGridCount));
            deleteCurrentVehiclePage.setEnabled(true);
        } else {
            picturePanel2.remove(vehicleGrids.get(currentVehicleGrid));
            currentVehicleGrid++;
            reDrawVehicleGrid(vehicleGrids.get(currentVehicleGrid));
        }

        //JOptionPane.showMessageDialog(this, " cvg" + currentVehicleGrid + "   vgc" + vehicleGridCount);
        updateArrows();


    }//GEN-LAST:event_rightArrowMousePressed

    private void leftArrowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMousePressed
        // TODO add your handling code here:
        picturePanel2.remove(vehicleGrids.get(currentVehicleGrid));
        currentVehicleGrid--;
        reDrawVehicleGrid(vehicleGrids.get(currentVehicleGrid));

        //JOptionPane.showMessageDialog(this, " cvg" + currentVehicleGrid + "   vgc" + vehicleGridCount);
        updateArrows();
    }//GEN-LAST:event_leftArrowMousePressed

    private void templatesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templatesMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().open(new File(getProgramPath() + "\\conx\\templates\\"));
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }//GEN-LAST:event_templatesMenuItemActionPerformed

    private void deleteCurrentVehiclePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCurrentVehiclePageActionPerformed
        // TODO add your handling code here:

        int answer = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete this page of vehicles?", "Confirmation", JOptionPane.WARNING_MESSAGE);
        if (answer == 0) {
            picturePanel2.remove(vehicleGrids.get(currentVehicleGrid));
            currentVehicleGrid--;
            reDrawVehicleGrid(vehicleGrids.get(currentVehicleGrid));
            vehicleGridCount--;
            updateArrows();

            vehicleGrids.remove(currentVehicleGrid + 1);

            //JOptionPane.showMessageDialog(this, " cvg" + currentVehicleGrid + "   vgc" + vehicleGridCount );
            updateArrows();

            revalidate();
            repaint();
        }

    }//GEN-LAST:event_deleteCurrentVehiclePageActionPerformed

    /**
     * showRightArrow() makes it so that the right arrow appear
     */
    public void showRightArrow() {
        this.rightArrow.setVisible(true);
    }

    /**
     * showLeftArrow() makes it so that the left arrow appear
     */
    public void showLeftArrow() {
        this.leftArrow.setVisible(true);
    }

    /**
     * hideRightArrow() makes it so that the right arrow disappears
     */
    public void hideRightArrow() {
        this.rightArrow.setVisible(false);
    }

    /**
     * hideLeftArrow() makes it so that the left arrow disappears
     */
    public void hideLeftArrow() {
        this.leftArrow.setVisible(false);
    }

    /**
     * The Main method
     *
     * @param args the comainMenuand line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().display();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel additionalInfoPanel;
    private convoy.gui.AdditionalTextPanel additionalTextPanel1;
    private javax.swing.JMenuItem deleteCurrentVehiclePage;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem finalizeMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel leftArrow;
    protected convoy.gui.LeftMissionInfoPanel leftMissionInfoPanel1;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel missionNumberPanel;
    private javax.swing.JMenuItem newMenuItem;
    private convoy.gui.PicturePanel picturePanel2;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JLabel rightArrow;
    protected convoy.gui.RightMissionInfoPanel rightMissionInfoPanel2;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem templatesMenuItem;
    protected convoy.gui.VehicleGrid vehicleGrid1;
    private javax.swing.JMenuItem wateMarkMenu;
    // End of variables declaration//GEN-END:variables
}
