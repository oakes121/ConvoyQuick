package textEditor2;

/**
 * Blue Writer, a java word processor through RTF
 * @author Joseph Lewis III
 * @version June 20, 2008
 *  GNU Public Licence 3
 * */
 
//Import Items
    //java
        //awt
        import java.awt.*;
        import java.awt.BorderLayout; //import the layout for the app
        import java.awt.event.*; // import the event handeler
        //IO
        import java.io.*;
        import java.io.BufferedInputStream;
        import java.io.DataInputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        //Util
        import java.util.HashMap;
    //javax
        import javax.swing.text.rtf.RTFEditorKit;
        import javax.swing.text.DefaultEditorKit.*;//used for the cut copy paste action
        import javax.swing.text.StyleContext;//Creates colors, 
        import javax.swing.text.DefaultStyledDocument; //Creates document editing for paragraphs and letters
        import javax.swing.text.JTextComponent; //supposedly for using get action by name
        import javax.swing.*; //import the swing for use to make app
        import javax.swing.text.StyledEditorKit; // alows simple text formatting (bold, italics, underline)
        import javax.swing.text.*;
        import javax.swing.event.*;
        import javax.swing.undo.*;
        import javax.swing.text.StyledEditorKit.BoldAction; // allows bold action only


public class BlueWriter extends JFrame{

    //Begin Instinating Variables
        public boolean save; // used for checking if the document is saved before closing and if pressed ctl+s
        public String docName, docFilePath;// Doc Name is for the document name to set in the titlebar and doc file path is for the save and open dialouges to automaticly save and open in the same path
        public DefaultStyledDocument doc; // A default styled document for everything to use
        public JToolBar formattingToolBar;
        HashMap<Object, Action> actions;//Make a HashMap that allows other objects to get actions by name
    //End Instinating Variables
    
    public BlueWriter(){   
        
        JOptionPane.showMessageDialog(this,"This is an ALPHA version of BlueWriter, to submit bugs goto:\n bluewriter.sourceforge.net and click bugs.\n \n If you do not wish to use Alpha versions goto bluewriter.sourceforge.net\nand try to find a Beta version. ");
          
        //Set window Attributes
            this.setSize(700,500); //Set Size of frame
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//on press close do nothing, a listener will listen and run the quit area when close is pressed
            this.setTitle("BlueWriter-NewDocument.rtf*");//Sets the title of the frame when saved will reset to "BlueWriter- SAVED DOCUMENT NAME.RTF" when edited the star will appear meaning not saved since last edit
            this.setLocationRelativeTo (null);//set in center of screen
            this.setIconImage(         Toolkit.getDefaultToolkit().getImage("icons/blueofficeicon/bluewritericonnew.png")         );// Post the blueoffice image
        
        //Setup document name
        docName = "New Document";
        
        //begin making the swing items

        //Panel
                JPanel panel = new JPanel();//Creates the main panel
                panel.setLayout(new BorderLayout());//add the boarder area North South East West Center

                //Text Area for User
                JTextPane textArea = new JTextPane();//creates a new text area
                JScrollPane docScroller = new JScrollPane(textArea);// Adds a scroller to the text area
                    panel.add(docScroller, BorderLayout.CENTER);//Add the entire thing to the main panel in the center area

                    //Set the RTF Editor Kit
                    RTFEditorKit rtf = new RTFEditorKit();
                        textArea.setEditorKit(rtf);//allows formatting of the text area
                            StyleContext context = new StyleContext();//Allows colours, and other document styles
                              doc = new DefaultStyledDocument(context);//allows paragraph formatting etc                           
                              textArea.setDocument(doc); //set the default document that allows colours and other styles to the text area


                 //Allow Image Loading while in JAR format
                 ClassLoader cl = this.getClass().getClassLoader();

        //Create the menubar and the menus
        JMenuBar menuBar = new JMenuBar();//Creates a menu bar to hold all of the menus.
        JMenu file = new JMenu("File"); //Creates the file menu
        JMenu edit = new JMenu("Edit"); //Creates the edit menu
        JMenu view = new JMenu("View"); //Creates the view menu and submenus
        JMenu insert = new JMenu("Insert");//Creates the insert menu
        JMenu tools = new JMenu("Tools"); //Creates the tools menu
        JMenu table = new JMenu("Table"); //Creates the Table menu
        JMenu help = new JMenu("Help"); //Creates the help menu
            //Create the menu Items
                //File
                    //New
                    JMenuItem fileNew = new JMenuItem("New");
                    ImageIcon iconNew = new ImageIcon(getClass().getResource("icons/file_new.png"));
                    Action newDoc = new AbstractAction("New", iconNew){public void actionPerformed (ActionEvent e) {newMethod();}};
                    fileNew.setAction(newDoc);
                    fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
                    fileNew.setToolTipText("Click this button to make a new document window.");
                    //Save
                    JMenuItem fileSave = new JMenuItem("Save");
                    ImageIcon iconSave = new ImageIcon(getClass().getResource("icons/file_save.png"));
                    Action saveDoc = new AbstractAction("Save", iconSave){public void actionPerformed (ActionEvent e) {saveMethod();}};
                    fileSave.setAction(saveDoc);;
                    fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
                    fileSave.setToolTipText("Click this button to Save your document.");
                    //Save As
                    JMenuItem fileSaveAs = new JMenuItem("Save As");
                    ImageIcon iconSaveas = new ImageIcon(getClass().getResource("icons/file_saveas.png"));
                    Action saveasDoc = new AbstractAction("Save As", iconSaveas){public void actionPerformed (ActionEvent e) {save = false; saveMethod();}};
                    fileSaveAs.setAction(saveasDoc);
                    fileSaveAs.setToolTipText("Click this button to save the document as something else than what it is now.");
                    //Open
                    JMenuItem fileOpen = new JMenuItem("Open");
                    ImageIcon iconOpen = new ImageIcon(getClass().getResource("icons/file_open.png"));
                    Action openDoc = new AbstractAction("Open", iconOpen){public void actionPerformed (ActionEvent e) {openMethod();}};
                    fileOpen.setAction(openDoc);
                    fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
                    fileOpen.setToolTipText("Click this button open a document in a new window.");
                    //Print
                    JMenuItem filePrint = new JMenuItem("Print");
                    ImageIcon iconPrint = new ImageIcon(getClass().getResource("icons/file_print.png"));
                    Action printDoc = new AbstractAction("Print", iconPrint){public void actionPerformed (ActionEvent e) {    ;}};
                    filePrint.setAction(printDoc);
                    filePrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
                    filePrint.setToolTipText("Click this button to print the document.");
                    //Quit
                    JMenuItem fileQuit = new JMenuItem("Quit");
                    ImageIcon iconQuit = new ImageIcon(getClass().getResource("icons/file_quit.png"));
                    Action quitDoc = new AbstractAction("Quit", iconQuit){public void actionPerformed (ActionEvent e) {onQuit();}};
                    fileQuit.setAction(quitDoc);
                    fileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
                    fileQuit.setToolTipText("Click this button close this document.");
                    
                //Edit
                    //Undo
                    JMenuItem editUndo = new JMenuItem("Undo");
                    ImageIcon iconUndo = new ImageIcon(getClass().getResource("icons/edit_undo.png"));
                    Action undoObj = new AbstractAction("Undo", iconUndo){public void actionPerformed (ActionEvent e) {     ;}};
                    editUndo.setAction(undoObj);
                    editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
                    editUndo.setToolTipText("Undo editing text.");
                    //Cut
                    JMenuItem editCut = new JMenuItem("Cut");
                    ImageIcon iconCut = new ImageIcon(getClass().getResource("icons/edit_cut.png"));
                    Action cutObj = new AbstractAction("Cut", iconCut){public void actionPerformed (ActionEvent e) {getActionByName(DefaultEditorKit.cutAction);}};
                    editCut.setAction(cutObj);
                    editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                    editCut.setToolTipText("Take out some text and allow it to be pasted elsewhere.");
                    //Copy
                    JMenuItem editCopy = new JMenuItem("Copy");
                    ImageIcon copyIcon = new ImageIcon(getClass().getResource("icons/edit_copy.png"));
                    Action copyAction = new AbstractAction("Copy",copyIcon){public void actionPerformed (ActionEvent e) {;}};
                    editCopy.setAction(copyAction);
                    editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
                    editCopy.setToolTipText("Copy some text and allow it to be pasted elsewhere.");
                    //Paste
                    JMenuItem editPaste = new JMenuItem("Paste");
                    ImageIcon iconPaste = new ImageIcon(getClass().getResource("icons/edit_paste.png"));
                    Action pasteObj = new AbstractAction("Paste",iconPaste){public void actionPerformed (ActionEvent e) {   ;}};
                    editPaste.setAction(pasteObj);
                    editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
                    editPaste.setToolTipText("Put some text allready copied/cut in here.");
                    //Clear Formatting
                    JMenuItem editClear = new JMenuItem("Clear Formatting");
                    //Find and Replace
                    JMenuItem editFind = new JMenuItem("Find and Replace");
                    ImageIcon iconFind = new ImageIcon(getClass().getResource("icons/edit_find.png"));
                    Action findAction = new AbstractAction("Find and Replace",iconFind){public void actionPerformed (ActionEvent e) {findAndReplace();}};
                    editFind.setAction(findAction);
                    editFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
                    editFind.setToolTipText("Find and or Replace certain words in this document");
                    
                //View
                    JMenu viewToolbars = new JMenu("Toolbars");
                    //Formatting Tool Bar
                    JMenuItem viewFormatting = new JMenuItem("Formatting");
                    Action viewFormattingAction = new AbstractAction("Formatting"){public void actionPerformed (ActionEvent e) {   }};
                    viewFormatting.setAction(viewFormattingAction);
                    viewFormatting.setToolTipText("Show The Formatting Toolbar");
                    
  
                    
                //Insert
                    JMenuItem insertPicture = new JMenuItem("Picture");
                    ImageIcon iconPicture = new ImageIcon(getClass().getResource("icons/insert_picture.png"));
                    Action pictureAction = new AbstractAction("Picture",iconPicture){public void actionPerformed (ActionEvent e) {   }};
                    insertPicture.setAction(pictureAction);
                    
                    JMenuItem insertBreak = new JMenuItem("Page Break");
                    
                    JMenuItem insertFootnote = new JMenuItem("Footnote");
                    //Tools
                    JMenuItem toolsWordcount = new JMenuItem("Word Count");
                    JMenuItem toolsSpell = new JMenuItem("Spell Check");
                    JMenuItem toolsEnvelope = new JMenuItem("Envelope");
                //Table
                
                //Help
                    //Help Topics
                    JMenuItem helpTopics = new JMenuItem("Help Topics");
                    ImageIcon iconHelp = new ImageIcon(getClass().getResource("icons/help_help.png"));
                    Action helpAction = new AbstractAction("Help Topics",iconHelp){public void actionPerformed (ActionEvent e) {}};
                    helpTopics.setAction(helpAction);
                    helpTopics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
                    //About Blue Writer
                    JMenuItem helpAbout = new JMenuItem("About Blue Writer");
                    ImageIcon iconAbout = new ImageIcon(getClass().getResource("icons/help_about.png"));
                    Action aboutAction = new AbstractAction("About Blue Writer",iconAbout){public void actionPerformed (ActionEvent e) {aboutBox();}};
                    helpAbout.setAction(aboutAction);
                    //Learn Blue Writer
                    JMenuItem helpLessons = new JMenuItem("Learn Blue Writer");
                    ImageIcon iconLearn = new ImageIcon(getClass().getResource("icons/help_learn.png"));
                    Action lessonsAction = new AbstractAction("Learn Blue Writer",iconLearn){public void actionPerformed (ActionEvent e) {;}};
                    helpLessons.setAction(lessonsAction);
                    
            //Associate the menus with the bar and the bar with the applet
                //file
                file.add(fileNew);
                file.addSeparator();
                file.add(fileSave);
                file.add(fileSaveAs);
                file.add(fileOpen);
                file.addSeparator();
                file.add(filePrint);
                file.addSeparator();
                file.add(fileQuit);
                //edit
                edit.add(editUndo);
                edit.addSeparator();
                edit.add(editCut);
                edit.add(editCopy);
                edit.add(editPaste);
                edit.addSeparator();
                edit.add(editClear);
                edit.add(editFind);
                //View
                view.add(viewToolbars);
                    viewToolbars.add(viewFormatting);
                //Insert
                insert.add(insertPicture);
                insert.add(insertBreak);
                insert.add(insertFootnote);
                //tools
                tools.add(toolsWordcount);
                tools.add(toolsSpell);
                tools.addSeparator();
                tools.add(toolsEnvelope);
                //Table
                
                //Help
                help.add(helpTopics);
                help.add(helpLessons);
                help.addSeparator();
                help.add(helpAbout);
                //associate menus with bar
                menuBar.add(file);
                menuBar.add(edit);
                menuBar.add(view);
                menuBar.add(insert);
                menuBar.add(tools);
                menuBar.add(help);

                
            //Set Menubar On Top Of Java File
                    this.setJMenuBar(menuBar);
                    
       

            //Formatting Toolbar
               JToolBar formattingToolBar = new JToolBar();
                
                //New
                JButton newButton = new JButton("",iconNew);
                newButton.setAction(newDoc);
                newButton = new JButton("",iconNew);
                formattingToolBar.add(newButton);
                
                //Open
                JButton openButton = new JButton("",iconOpen);
                openButton.setAction(openDoc);
                openButton = new JButton("",iconOpen);
                formattingToolBar.add(openButton);
                
                //Save
                JButton saveButton = new JButton("",iconSave);
                saveButton.setAction(saveDoc);
                saveButton = new JButton("",iconSave);
                formattingToolBar.add(saveButton);
                
                formattingToolBar.addSeparator();
                
                
                //Bold
                ImageIcon iconBold = new ImageIcon(getClass().getResource("icons/text_bold.png"));
                JToggleButton boldButton = new JToggleButton("Bold",iconBold);
                Action boldAction = new AbstractAction("",iconBold){public void actionPerformed (ActionEvent e) { }};
                boldButton.setAction(boldAction);
                formattingToolBar.add(boldButton);
                
                //Italics
                ImageIcon iconItalics = new ImageIcon(getClass().getResource("icons/text_italic.png"));
                JToggleButton italicsButton = new JToggleButton("Italics",iconItalics);
                Action italicsAction = new AbstractAction("",iconItalics){public void actionPerformed (ActionEvent e) { }};
                italicsButton.setAction(italicsAction);
                formattingToolBar.add(italicsButton);
                
                //Underline
                ImageIcon iconUnderline = new ImageIcon(getClass().getResource("icons/text_underline.png"));
                JToggleButton underlineButton = new JToggleButton("Underline",iconUnderline);
                Action underlineAction = new AbstractAction("",iconUnderline){public void actionPerformed (ActionEvent e) { }};
                underlineButton.setAction(underlineAction);
                formattingToolBar.add(underlineButton);
                
                //Close
                ImageIcon iconClose = new ImageIcon(getClass().getResource("icons/text_Close.png"));
                JButton CloseButton = new JButton("Close",iconClose);
                Action CloseAction = new AbstractAction("",iconClose){public void actionPerformed (ActionEvent e) {    }};
                CloseButton.setAction(CloseAction);
                formattingToolBar.add(CloseButton);
                
                    panel.add(formattingToolBar, BorderLayout.NORTH);




        //==========================================Things For The Main Panel================================================
        this.add(panel);//Add the panel to the area.
        this.setVisible (true);//makes the component visible
        textArea.grabFocus();

        //+++++++++++++++++window on quit++++++++++++++++++++++
         WindowListener wndCloser = new WindowAdapter() {

             public void windowClosing(WindowEvent e) {
                 onQuit();
                }
            };
            addWindowListener(wndCloser);
        //+++++++++++++++++End On Quit++++++++++++++++++++++
                    
                }
                    
                
//================================================================================================================================================
//==================================================METHODS GO BELOW THIS LINE====================================================================
//================================================================================================================================================

   
    public static void main(String[] args)
    {
        
          //Set to look like windows:
          try {
              UIManager.setLookAndFeel(
              "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          } catch (Exception e) { }

        
        
        new BlueWriter();
    }
    

    /**
     * The about option displays an about box for information
     * Added July 10, 2008
     */
    public void aboutBox(){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this," BlueWriter Test Edition\n Made by: Joseph Lewis III \n Date: June 27, 2008 \n Version: 2.XXXXXXXX \n Licence: GNU 3","About BlueWriter",JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    /**
     * The find and replace option makes a find and replace box for the user...
     */
    public void findAndReplace(){
        JDialog findAndReplace = new JDialog();//Create a find and replace box
        JTabbedPane findReplace = new JTabbedPane();//Create a tabbed area one tab for find and one for replace
            JPanel findTab = new JPanel(); //Set the internal panel for the find tab, with border layout
                findTab.setLayout(new BorderLayout());
                    JPanel East = new JPanel();//Make a new panel that will go in the east of the find tab panel
                        JButton find = new JButton("Find Next");//Add a Find Button to the east pannel
                            East.add(find);
                        JButton close = new JButton("Close");//Add a close button to the east pannel
                            East.add(close);
                    findTab.add(East,BorderLayout.EAST);//Add the east layout to the find tab
        JLabel findLabel = new JLabel ("Find What:");
        findTab.add(findLabel,BorderLayout.WEST);
        JTextField findBox = new JTextField();
        findTab.add(findBox,BorderLayout.CENTER);
        //Options Area
        JPanel replaceTab = new JPanel();
        replaceTab.setLayout(new BorderLayout());
        findReplace.addTab("Find",null, findTab, "Allows you to find text within the document"); 
        findReplace.addTab("Replace",null, replaceTab, "Allows you to find certain text in the document and replace it with other text"); 
        findAndReplace.add(findReplace);
        findAndReplace.setSize(400,50);
        findAndReplace.setLocationRelativeTo (this);
        findAndReplace.setVisible(true);
     }


     /**
     * Quit Method checks if the file is saved before quitting... using the variable save, there will be a backround process that checks
     * if the file has been changed untill it is then puts up the star after the title and sets save equal to false...
     */
    public void onQuit(){
       if(save == false){
           Toolkit.getDefaultToolkit().beep();//beep before mesage
           JOptionPane.showMessageDialog(this,"Warning: due to bugs this will close all open BlueWriter windows.\n Unless you Press Cancel On The Next Screen","Bug Notification:",JOptionPane.ERROR_MESSAGE);
           int n = JOptionPane.showConfirmDialog(this,"Do you want to save before you quit?","Quit?",JOptionPane.YES_NO_CANCEL_OPTION);
           if (n == JOptionPane.NO_OPTION){ System.exit(0);}//if the user presses yes then quit
           if (n == JOptionPane.YES_OPTION){saveMethod(); System.exit(0);}
        }//new dialouge if not saved
        else{
            this.dispose();
        }
    }
    
    
     public void saveMethod(){
        if(save != true){ //if document not saved
            RTFEditorKit rtf = new RTFEditorKit(); //make a new editor kit because the last one will not be accessable from this method
            //build the file chooser...
            JFileChooser savechooser = new JFileChooser(docFilePath); // if the user has saved before the docFilePath should let them go to the directory with the file in it
            int output = savechooser.showSaveDialog (this); // Make the new save dialouge
           
            if (output == JFileChooser.APPROVE_OPTION){   //If user presses yes output the file
                File file = savechooser.getSelectedFile(); //make the file in the selected directory
                    try {
                        docName = file.getName()+".rtf"; //Set the name to the file name pluse the extention .rtf
                        docFilePath = file.getPath();  //Set the docFilePath so next time it will save to the same directory.
                        OutputStream out = new FileOutputStream(file); // make a new output stream
                        rtf.write(out, doc, 0, doc.getLength()); //Using the output stream output the document from character 0 to the end of the document
                        out.close(); // Close the output stream so that the memory usage will be smaller
                        save = true; // sets the saved message to true so if a person hits Ctl+S the document will not be messed up and saved again
                    }//End Try
                    catch (Exception ex) {//Catch an exception, this is a IO error, on this print out somthing the user can see
                        Toolkit.getDefaultToolkit().beep();//beep before mesage
                        JOptionPane.showMessageDialog(this,"The Save Document Item Is Not Working...\n"+ ex,"Fatal Save Error:",JOptionPane.ERROR_MESSAGE);
                    } //End Catch
            }//End If is approve option
        }//End if save != true
    }//End Save Method
    

    
    /**
    * Open Method
    */
   public void openMethod(){
        RTFEditorKit rtf = new RTFEditorKit();
        if(save == false){
           Toolkit.getDefaultToolkit().beep();//Beep before mesage
           int n = JOptionPane.showConfirmDialog(this,"Do you want to save before you\nopen another document in this\nwindow?","Save?",JOptionPane.YES_NO_OPTION);
           if (n == JOptionPane.YES_OPTION){saveMethod();}
        }//new dialouge if not saved
        JFileChooser openchooser = new JFileChooser(docFilePath);
        int input = openchooser.showOpenDialog (this);
        if(input == JFileChooser.APPROVE_OPTION){
            File file = openchooser.getSelectedFile();
            try {
                docName = file.getName();
                docFilePath = file.getPath();
                InputStream in = new FileInputStream(file);
                rtf.read(in, doc, 0);
                in.close();
                save = true;
                
            }//End Try
            catch (Exception ex) {//Catch an IO Error Exception and print out the following
                JOptionPane.showMessageDialog(this,"The Open Document Item Is Not Working...\n     1. The document is not a RTF\n     2.Unknown Error","Open Error:\n"+ex,JOptionPane.ERROR_MESSAGE);
            }//end catch
        }//End if
    }//End Open Method

    
    
    /**
     * New Method
     *
     * Makes a new Blue Writer (hopefully in a new thread.
     **/
     public void newMethod(){

         new BlueWriter();
        }//End New Method
                
        
        
        
        
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++DO NOT EDIT BEYOND THIS POINT FOR FEAR OF DEATH+++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Taken from the java examples library;
//The next two methods will allow for getting acions by name, instead of having to declare them all in the import area
//whoever did this deserves heavy congradulations.

private HashMap<Object, Action> createActionTable(JTextComponent textArea) {
        HashMap<Object, Action> actions = new HashMap<Object, Action>();
        Action[] actionsArray = textArea.getActions();
        for (int i = 0; i < actionsArray.length; i++) {
            Action a = actionsArray[i];
            actions.put(a.getValue(Action.NAME), a);
        }
    return actions;
    }
     
private Action getActionByName(String name) {
        return actions.get(name);
    }
    
}//End Bluewriter

//Made By Joseph Lewis GNU Public Licence 3