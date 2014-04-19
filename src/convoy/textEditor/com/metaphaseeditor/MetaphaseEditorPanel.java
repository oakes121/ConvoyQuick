/**
 * Metaphase Editor - WYSIWYG HTML Editor Component
 * Copyright (C) 2010  Rudolf Visagie
 * Full text of license can be found in /textEditor/com/metaphaseeditor/LICENSE.txt
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * The author can be contacted at metaphase.editor@gmail.com.
 */

package convoy.textEditor.com.metaphaseeditor;

import convoy.textEditor.com.metaphaseeditor.action.AddAttributesAction;
import convoy.textEditor.com.metaphaseeditor.action.DecreaseIndentAction;
import convoy.textEditor.com.metaphaseeditor.action.FindReplaceAction;
import convoy.textEditor.com.metaphaseeditor.action.FormatAction;
import convoy.textEditor.com.metaphaseeditor.action.IncreaseIndentAction;
import convoy.textEditor.com.metaphaseeditor.action.RemoveAttributesAction;
import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.swing.JTextComponentSpellChecker;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Rudolf Visagie
 */
public class MetaphaseEditorPanel extends javax.swing.JPanel {
    
    private JTextComponentSpellChecker spellChecker = null;
    private SpellDictionary dictionary = null;
    private JTextArea htmlTextArea;
    private boolean htmlSourceMode = false;    
    private SpecialCharacterDialog specialCharacterDialog = new SpecialCharacterDialog(null, true);
    private Hashtable<Object, Action> editorKitActions;
    private SpellCheckDictionaryVersion spellCheckDictionaryVersion = SpellCheckDictionaryVersion.LIBERAL_US;
    private String customDictionaryFilename = null;

    /** Listener for the edits on the current document. */
    protected UndoableEditListener undoHandler = new UndoHandler();

    /** UndoManager that we add edits to. */
    protected UndoManager undo = new UndoManager();

    private UndoAction undoAction = new UndoAction();
    private RedoAction redoAction = new RedoAction();
    private HTMLEditorKit.CutAction cutAction = new HTMLEditorKit.CutAction();
    private HTMLEditorKit.CopyAction copyAction = new HTMLEditorKit.CopyAction();
    private HTMLEditorKit.PasteAction pasteAction = new HTMLEditorKit.PasteAction();
    private FindReplaceAction findReplaceAction;

    private HTMLEditorKit editorKit = new HTMLEditorKit();

    private JPopupMenu contextMenu;

    private List<ContextMenuListener> contextMenuListeners = new ArrayList<ContextMenuListener>();
    private List<EditorMouseMotionListener> editorMouseMotionListeners = new ArrayList<EditorMouseMotionListener>();

    private enum ParagraphFormat {
        PARAGRAPH_FORMAT("Format", null),
        NORMAL("Normal", Tag.P),
        HEADING1("Heading 1", Tag.H1),
        HEADING2("Heading 2", Tag.H2),
        HEADING3("Heading 3", Tag.H3),
        HEADING4("Heading 4", Tag.H4),
        HEADING5("Heading 5", Tag.H5),
        HEADING6("Heading 6", Tag.H6),
        FORMATTED("Formatted", Tag.PRE),
        ADDRESS("Address", Tag.ADDRESS);

        private String text;
        private Tag tag;

        ParagraphFormat(String text, Tag tag) {
            this.text = text;
            this.tag = tag;
        }

        public Tag getTag() {
            return tag;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private enum FontItem {
        FONT("Font", null),
        ARIAL("Arial", "Arial"),
        COMIC_SANS_MS("Comic Sans MS", "Comic Sans MS"),
        COURIER_NEW("Courier New", "Courier New"),
        GEORGIA("Georgia", "Georgia"),
        LUCINDA_SANS_UNICODE("Lucinda Sans Unicode", "Lucinda Sans Unicode"),
        TAHOMA("Tahoma", "Tahoma"),
        TIMES_NEW_ROMAN("Times New Roman", "Times New Roman"),
        TREBUCHET_MS("Trebuchet MS", "Trebuchet MS"),
        VERDANA("Verdana", "Verdana");

        private String text;
        private String fontName;

        FontItem(String text, String fontName) {
            this.text = text;
            this.fontName = fontName;
        }

        public String getText() {
            return text;
        }

        public String getFontName() {
            return fontName;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private enum FontSize {
        FONT_SIZE("Size", -1),
        SIZE8("8", 8),
        SIZE9("9", 9),
        SIZE10("10", 10),
        SIZE11("11", 11),
        SIZE12("12", 12),
        SIZE14("14", 14),
        SIZE18("18", 18),
        SIZE20("20", 20),
        SIZE22("22", 22),
        SIZE24("24", 24),
        SIZE26("26", 26),
        SIZE28("28", 28),
        SIZE36("36", 36),
        SIZE48("48", 48),
        SIZE72("72", 72);

        private String text;
        private int size;

        FontSize(String text, int size) {
            this.text = text;
            this.size = size;
        }

        public String getText() {
            return text;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return text;
        }
    }
    
    /** Creates new form MetaphaseEditorPanel */
    public MetaphaseEditorPanel() {        
        initComponents();

        createEditorKitActionTable();
        
        htmlTextArea = new JTextArea();
        htmlTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        htmlTextPane.setContentType("text/html");

        findReplaceAction = new FindReplaceAction("Find/Replace", htmlTextPane);
        /*
        cutButton.setAction(cutAction);
        cutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/cut.png")));
        cutButton.setText("");
        cutButton.setToolTipText("Cut");

        copyButton.setAction(copyAction);
        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/copy.png")));
        copyButton.setText("");
        copyButton.setToolTipText("Copy");

        pasteButton.setAction(pasteAction);
        pasteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/paste.png")));
        pasteButton.setText("");
        pasteButton.setToolTipText("Paste");

        undoButton.setAction(undoAction);
        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/undo.png")));
        undoButton.setText("");
        undoButton.setToolTipText("Undo");

        redoButton.setAction(redoAction);
        redoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/redo.png")));
        redoButton.setText("");
        redoButton.setToolTipText("Redo");

        findButton.setAction(findReplaceAction);
        findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/find.png")));
        findButton.setText("");
        findButton.setToolTipText("Find");

        replaceButton.setAction(findReplaceAction);
        replaceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/replace.png")));
        replaceButton.setText("");
        replaceButton.setToolTipText("Replace");

        clearFormattingButton.setAction(new ClearFormattingAction(this, "Remove Format"));
        clearFormattingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/removeformat.png")));
        clearFormattingButton.setText("");
        clearFormattingButton.setToolTipText("Remove Format");
        */
        boldButton.setAction(new HTMLEditorKit.BoldAction());
        boldButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/bold.png")));
        boldButton.setText("");
        boldButton.setToolTipText("Bold");

        italicButton.setAction(new HTMLEditorKit.ItalicAction());
        italicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/italic.png")));
        italicButton.setText("");
        italicButton.setToolTipText("Italic");

        underlineButton.setAction(new HTMLEditorKit.UnderlineAction());
        underlineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/underline.png")));
        underlineButton.setText("");
        underlineButton.setToolTipText("Underline");

        strikethroughButton.setAction(new StrikeThroughAction());
        strikethroughButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/strikethrough.png")));
        strikethroughButton.setText("");
        strikethroughButton.setToolTipText("Strike Through");
        /*
        subscriptButton.setAction(new SubscriptAction());
        subscriptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/subscript.png")));
        subscriptButton.setText("");
        subscriptButton.setToolTipText("Subscript");
        
        superscriptButton.setAction(new SuperscriptAction());
        superscriptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/superscript.png")));
        superscriptButton.setText("");
        superscriptButton.setToolTipText("Superscript");
        */
        //TODO: change increase and decrease indent to add inner <li> when inside bulleted or numbered list
        increaseIndentButton.setAction(new IncreaseIndentAction("Increase Indent", this));
        increaseIndentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/incindent.png")));
        increaseIndentButton.setText("");
        increaseIndentButton.setToolTipText("Increase Indent");

        decreaseIndentButton.setAction(new DecreaseIndentAction("Decrease Indent", this));
        decreaseIndentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/decindent.png")));
        decreaseIndentButton.setText("");
        decreaseIndentButton.setToolTipText("Decrease Indent");
        /*
        blockQuoteButton.setAction(new FormatAction(this, "Block Quote", Tag.BLOCKQUOTE));
        blockQuoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/blockquote.png")));
        blockQuoteButton.setText("");
        blockQuoteButton.setToolTipText("Block Quote");
        */
        leftJustifyButton.setAction(new HTMLEditorKit.AlignmentAction("Left Align",StyleConstants.ALIGN_LEFT));
        leftJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/leftjustify.png")));
        leftJustifyButton.setText("");
        leftJustifyButton.setToolTipText("Left Justify");

        centerJustifyButton.setAction(new HTMLEditorKit.AlignmentAction("Center Align",StyleConstants.ALIGN_CENTER));
        centerJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/centerjustify.png")));
        centerJustifyButton.setText("");
        centerJustifyButton.setToolTipText("Center Justify");

        rightJustifyButton.setAction(new HTMLEditorKit.AlignmentAction("Left Align",StyleConstants.ALIGN_RIGHT));
        rightJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/rightjustify.png")));
        rightJustifyButton.setText("");
        rightJustifyButton.setToolTipText("Right Justify");

        blockJustifyButton.setAction(new HTMLEditorKit.AlignmentAction("Justified Align",StyleConstants.ALIGN_JUSTIFIED));
        blockJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/blockjustify.png")));
        blockJustifyButton.setText("");
        blockJustifyButton.setToolTipText("Block Justify");
        /*
        unlinkButton.setAction(new UnlinkAction(this, "Unlink"));
        unlinkButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/unlink.png")));
        unlinkButton.setText("");
        unlinkButton.setToolTipText("Unlink");
        
        //TODO: horizontal rule - doesn't insert correctly if within anything other than P, ie. TD or H1
        insertHorizontalLineButton.setAction(new HTMLEditorKit.InsertHTMLTextAction("Insert Horizontal Line", "<hr/>", Tag.P, Tag.HR, Tag.BODY, Tag.HR));
        insertHorizontalLineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/horizontalline.png")));
        insertHorizontalLineButton.setText("");
        insertHorizontalLineButton.setToolTipText("Insert Horizontal Line");
        */
        paragraphFormatComboBox.setRenderer(new ParagraphFormatListCellRenderer());
        paragraphFormatComboBox.removeAllItems();
        ParagraphFormat[] paragraphFormats = ParagraphFormat.values();
        for (int i=0; i<paragraphFormats.length; i++) {
            paragraphFormatComboBox.addItem(paragraphFormats[i]);
        }

        fontComboBox.setRenderer(new FontListCellRenderer());
        fontComboBox.removeAllItems();
        FontItem[] fontItems = FontItem.values();
        for (int i=0; i<fontItems.length; i++) {
            fontComboBox.addItem(fontItems[i]);
        }

        fontSizeComboBox.setRenderer(new FontSizeListCellRenderer());
        fontSizeComboBox.removeAllItems();
        FontSize[] fontSizes = FontSize.values();
        for (int i=0; i<fontSizes.length; i++) {
            fontSizeComboBox.addItem(fontSizes[i]);
        }

        setToolbarFocusActionListener(this);

        htmlTextPane.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
        htmlTextPane.getActionMap().put("Undo", undoAction);

        htmlTextPane.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
        htmlTextPane.getActionMap().put("Redo", redoAction);

        htmlTextPane.getInputMap().put(KeyStroke.getKeyStroke("control F"), "Find");
        htmlTextPane.getActionMap().put("Find", findReplaceAction);

        htmlTextPane.getInputMap().put(KeyStroke.getKeyStroke("control R"), "Replace");
        htmlTextPane.getActionMap().put("Replace", findReplaceAction);

        contextMenu = new JPopupMenu();
        JMenuItem cutMenuItem = new JMenuItem();
        cutMenuItem.setAction(cutAction);
        cutMenuItem.setText("Cut");
        cutMenuItem.setMnemonic('C');
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/cut.png")));
        JMenuItem copyMenuItem = new JMenuItem();
        copyMenuItem.setAction(copyAction);
        copyMenuItem.setText("Copy");
        copyMenuItem.setMnemonic('o');
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/copy.png")));
        JMenuItem pasteMenuItem = new JMenuItem();
        pasteMenuItem.setAction(pasteAction);
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setMnemonic('P');
        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/paste.png")));
        contextMenu.add(cutMenuItem);
        contextMenu.add(copyMenuItem);
        contextMenu.add(pasteMenuItem);

        htmlTextPane.addMouseMotionListener(new DefaultEditorMouseMotionListener());
        htmlTextPane.setEditorKit(editorKit);

	startNewDocument();

        //initSpellChecker();
    }

    // The following two methods allow us to find an
    // action provided by the editor kit by its name.
    private void createEditorKitActionTable() {
        editorKitActions = new Hashtable<Object, Action>(); 
        Action[] actionsArray = editorKit.getActions();
        for (int i = 0; i < actionsArray.length; i++) {
            Action a = actionsArray[i];
            editorKitActions.put(a.getValue(Action.NAME), a);
        }
    }

    private Action getEditorKitActionByName(String name) {
        return editorKitActions.get(name);
    }

    protected void resetUndoManager() {
        undo.discardAllEdits();
        undoAction.update();
        redoAction.update();
    }

    public void startNewDocument(){
            Document oldDoc = htmlTextPane.getDocument();
            if(oldDoc != null)
                    oldDoc.removeUndoableEditListener(undoHandler);
            htmlDocument = (HTMLDocument)editorKit.createDefaultDocument();
            htmlTextPane.setDocument(htmlDocument);
            htmlTextPane.getDocument().addUndoableEditListener(undoHandler);
            resetUndoManager();
            //TODO: check if necessary
            htmlDocument.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
            htmlDocument.setPreservesUnknownTags(false);            
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        htmlDocument = new javax.swing.text.html.HTMLDocument();
        toolbarPanel = new javax.swing.JPanel();
        textEffectPanel = new javax.swing.JPanel();
        boldButton = new javax.swing.JButton();
        italicButton = new javax.swing.JButton();
        strikethroughButton = new javax.swing.JButton();
        underlineButton = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        insertRemoveBulletedListButton = new javax.swing.JButton();
        insertRemoveNumberedListButton = new javax.swing.JButton();
        blockPanel = new javax.swing.JPanel();
        decreaseIndentButton = new javax.swing.JButton();
        increaseIndentButton = new javax.swing.JButton();
        textColorButton = new javax.swing.JButton();
        backgroundColorButton = new javax.swing.JButton();
        paragraphFormatComboBox = new javax.swing.JComboBox();
        fontComboBox = new javax.swing.JComboBox();
        fontSizeComboBox = new javax.swing.JComboBox();
        justificationPanel = new javax.swing.JPanel();
        leftJustifyButton = new javax.swing.JButton();
        centerJustifyButton = new javax.swing.JButton();
        blockJustifyButton = new javax.swing.JButton();
        rightJustifyButton = new javax.swing.JButton();
        mainScrollPane = new javax.swing.JScrollPane();
        htmlTextPane = new javax.swing.JTextPane();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(760, 160));

        toolbarPanel.setBackground(new java.awt.Color(194, 178, 128));
        toolbarPanel.setPreferredSize(new java.awt.Dimension(700, 58));

        textEffectPanel.setBackground(new java.awt.Color(194, 178, 128));
        textEffectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textEffectPanel.setPreferredSize(new java.awt.Dimension(122, 29));

        boldButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/bold.png"))); // NOI18N
        boldButton.setToolTipText("Bold");

        italicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/italic.png"))); // NOI18N
        italicButton.setToolTipText("Italic");

        strikethroughButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/strikethrough.png"))); // NOI18N
        strikethroughButton.setToolTipText("Strike Through");

        underlineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/underline.png"))); // NOI18N
        underlineButton.setToolTipText("Underline");

        javax.swing.GroupLayout textEffectPanelLayout = new javax.swing.GroupLayout(textEffectPanel);
        textEffectPanel.setLayout(textEffectPanelLayout);
        textEffectPanelLayout.setHorizontalGroup(
            textEffectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textEffectPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(boldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(italicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(underlineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(strikethroughButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        textEffectPanelLayout.setVerticalGroup(
            textEffectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(italicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(underlineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(strikethroughButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(boldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        listPanel.setBackground(new java.awt.Color(194, 178, 128));
        listPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        insertRemoveBulletedListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/bulletlist.png"))); // NOI18N
        insertRemoveBulletedListButton.setToolTipText("Insert/Remove Bulleted List");
        insertRemoveBulletedListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRemoveBulletedListButtonActionPerformed(evt);
            }
        });

        insertRemoveNumberedListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/numberlist.png"))); // NOI18N
        insertRemoveNumberedListButton.setToolTipText("Insert/Remove Numbered List");
        insertRemoveNumberedListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRemoveNumberedListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertRemoveNumberedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(insertRemoveBulletedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(insertRemoveBulletedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(insertRemoveNumberedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        blockPanel.setBackground(new java.awt.Color(194, 178, 128));
        blockPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        blockPanel.setPreferredSize(new java.awt.Dimension(122, 29));

        decreaseIndentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/decindent.png"))); // NOI18N
        decreaseIndentButton.setToolTipText("Decrease Indent");

        increaseIndentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/incindent.png"))); // NOI18N
        increaseIndentButton.setToolTipText("Increase Indent");

        textColorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/textcolor.png"))); // NOI18N
        textColorButton.setToolTipText("Text Color");
        textColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textColorButtonActionPerformed(evt);
            }
        });

        backgroundColorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/backgroundcolor.png"))); // NOI18N
        backgroundColorButton.setToolTipText("Background Color");
        backgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundColorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout blockPanelLayout = new javax.swing.GroupLayout(blockPanel);
        blockPanel.setLayout(blockPanelLayout);
        blockPanelLayout.setHorizontalGroup(
            blockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(decreaseIndentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(increaseIndentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(textColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(backgroundColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        blockPanelLayout.setVerticalGroup(
            blockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blockPanelLayout.createSequentialGroup()
                .addGroup(blockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decreaseIndentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseIndentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backgroundColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        paragraphFormatComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Heading 1", "Heading 2", "Heading 3", "Heading 4", "Heading 5", "Heading 6", "Formatted", "Address", "Normal (DIV)" }));
        paragraphFormatComboBox.setToolTipText("Paragraph Format");
        paragraphFormatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paragraphFormatComboBoxActionPerformed(evt);
            }
        });

        fontComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "Comic Sans MS", "Courier New", "Georgia", "Lucinda Sans Unicode", "Tahoma", "Times New Roman", "Trebuchet MS", "Verdana" }));
        fontComboBox.setToolTipText("Font");
        fontComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontComboBoxActionPerformed(evt);
            }
        });

        fontSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" }));
        fontSizeComboBox.setToolTipText("Font Size");
        fontSizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeComboBoxActionPerformed(evt);
            }
        });

        justificationPanel.setBackground(new java.awt.Color(194, 178, 128));
        justificationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        justificationPanel.setPreferredSize(new java.awt.Dimension(122, 29));

        leftJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/leftjustify.png"))); // NOI18N
        leftJustifyButton.setToolTipText("Left Justify");

        centerJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/centerjustify.png"))); // NOI18N
        centerJustifyButton.setToolTipText("Center Justify");

        blockJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/blockjustify.png"))); // NOI18N
        blockJustifyButton.setToolTipText("Block Justify");

        rightJustifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/textEditor/com/metaphaseeditor/icons/rightjustify.png"))); // NOI18N
        rightJustifyButton.setToolTipText("Right Justify");

        javax.swing.GroupLayout justificationPanelLayout = new javax.swing.GroupLayout(justificationPanel);
        justificationPanel.setLayout(justificationPanelLayout);
        justificationPanelLayout.setHorizontalGroup(
            justificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(justificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(centerJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(rightJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(blockJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        justificationPanelLayout.setVerticalGroup(
            justificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(centerJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(blockJustifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paragraphFormatComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEffectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(toolbarPanelLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(justificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fontComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontSizeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(justificationPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEffectPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paragraphFormatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fontComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fontSizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        htmlTextPane.setText("Additional Information Goes Here");
        htmlTextPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                htmlTextPaneMouseClicked(evt);
            }
        });
        htmlTextPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                htmlTextPaneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                htmlTextPaneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                htmlTextPaneKeyTyped(evt);
            }
        });
        mainScrollPane.setViewportView(htmlTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextPane getHtmlTextPane() {
        return htmlTextPane;
    }

    public void setEditorToolTipText(String string) {
        htmlTextPane.setToolTipText(string);
    }

    public void addEditorMouseMotionListener(EditorMouseMotionListener editorMouseMotionListener) {
        editorMouseMotionListeners.add(editorMouseMotionListener);
    }

    public void removeEditorMouseMotionListener(EditorMouseMotionListener editorMouseMotionListener) {
        editorMouseMotionListeners.remove(editorMouseMotionListener);
    }

    public AttributeSet getSelectedParagraphAttributes() {
        int start = htmlTextPane.getSelectionStart();        

        Element element = htmlDocument.getParagraphElement(start);
        MutableAttributeSet attributes = new SimpleAttributeSet(element.getAttributes());

        Element charElement = htmlDocument.getCharacterElement(start);
        if (charElement != null) {
            Element impliedParagraph = charElement.getParentElement();
            if (impliedParagraph != null) {
                Element listElement = impliedParagraph.getParentElement();
                if (listElement.getName().equals("li")) {
                    // re-add the existing attributes to the list item
                    AttributeSet listElementAttrs = listElement.getAttributes();
                    Enumeration currentAttrEnum = listElementAttrs.getAttributeNames();
                    while (currentAttrEnum.hasMoreElements()) {
                        Object attrName = currentAttrEnum.nextElement();
                        Object attrValue = listElement.getAttributes().getAttribute(attrName);
                        if ((attrName instanceof String || attrName instanceof HTML.Attribute) && attrValue instanceof String) {
                            attributes.addAttribute(attrName, attrValue);
                        }
                    }
                }
            }
        }

        return attributes;
    }

    public void addAttributesToSelectedParagraph(Map<String, String> attributes) {
        new AddAttributesAction(this, "Add Attributes To Selected Paragraph", attributes).actionPerformed(null);
    }

    public void removeAttributesFromSelectedParagraph(String[] attributeNames) {
        new RemoveAttributesAction(this, "Remove Attributes From Selected Paragraph", attributeNames).actionPerformed(null);
    }

    public String getDocument() {
        return htmlTextPane.getText();
    }

    public void setDocument(String value) {
        try {
            StringReader reader = new StringReader(value);
            Document oldDoc = htmlTextPane.getDocument();
            if(oldDoc != null)
                oldDoc.removeUndoableEditListener(undoHandler);
            htmlDocument = (HTMLDocument)editorKit.createDefaultDocument();
            editorKit.read(reader, htmlDocument, 0);
            htmlDocument.addUndoableEditListener(undoHandler);
            htmlTextPane.setDocument(htmlDocument);
            resetUndoManager();
        } catch (BadLocationException e) {
            throw new MetaphaseEditorException(e.getMessage(), e);
        } catch (IOException e) {
            throw new MetaphaseEditorException(e.getMessage(), e);
        }
    }

    public JPopupMenu getContextMenu() {
        return contextMenu;
    }

    public void addStyleSheetRule(String rule) {
        StyleSheet styleSheet = editorKit.getStyleSheet();
        styleSheet.addRule(rule);
    }

    public void refreshAfterAction() {
        int pos = htmlTextPane.getCaretPosition();
        htmlTextPane.setText(htmlTextPane.getText());
        htmlTextPane.validate();
        try {
            htmlTextPane.setCaretPosition(pos);
        } catch (IllegalArgumentException e) {
            // swallow the exception
            // seems like a bug in the JTextPane component
            // only happens occasionally when pasting text at the end of a document
            System.err.println(e.getMessage());
        }
    }

    private void htmlTextPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_htmlTextPaneMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            for (int i=0; i<contextMenuListeners.size(); i++) {
                contextMenuListeners.get(i).beforeContextMenuPopup();
            }
            contextMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_htmlTextPaneMouseClicked

    private void htmlTextPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_htmlTextPaneKeyPressed
    }//GEN-LAST:event_htmlTextPaneKeyPressed

    private void htmlTextPaneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_htmlTextPaneKeyReleased
        
    }//GEN-LAST:event_htmlTextPaneKeyReleased

    private void htmlTextPaneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_htmlTextPaneKeyTyped
        if (evt.getKeyChar() == 10) {
            // TODO: currently this inserts two list items, fix this. PS it's not because of the two actions below, they will only insert when encountering either a UL or OL
            new HTMLEditorKit.InsertHTMLTextAction("Insert List Item", "<li></li>", Tag.UL, Tag.LI).actionPerformed(null);
            new HTMLEditorKit.InsertHTMLTextAction("Insert List Item", "<li></li>", Tag.OL, Tag.LI).actionPerformed(null);
        }
    }//GEN-LAST:event_htmlTextPaneKeyTyped

    private void fontSizeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontSizeComboBoxActionPerformed
        FontSize fontSize = (FontSize)fontSizeComboBox.getSelectedItem();
        if (fontSize != null && fontSize.getSize() != -1) {
            new HTMLEditorKit.FontSizeAction(fontSize.getText(), fontSize.getSize()).actionPerformed(evt);
        }
        if (fontSizeComboBox.getItemCount() > 0) {
            fontSizeComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_fontSizeComboBoxActionPerformed

    private void fontComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontComboBoxActionPerformed
        FontItem fontItem = (FontItem)fontComboBox.getSelectedItem();
        if (fontItem != null && fontItem.getFontName() != null) {
            new HTMLEditorKit.FontFamilyAction(fontItem.getText(), fontItem.getFontName()).actionPerformed(evt);
        }
        if (fontComboBox.getItemCount() > 0) {
            fontComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_fontComboBoxActionPerformed

    private void paragraphFormatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paragraphFormatComboBoxActionPerformed
        ParagraphFormat paragraphFormat = (ParagraphFormat)paragraphFormatComboBox.getSelectedItem();
        if (paragraphFormat != null && paragraphFormat.getTag() != null) {
            new FormatAction(this, "Paragraph Format", paragraphFormat.getTag()).actionPerformed(evt);
        }
        if (paragraphFormatComboBox.getItemCount() > 0) {
            paragraphFormatComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_paragraphFormatComboBoxActionPerformed

    private void backgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundColorButtonActionPerformed
        Color color = JColorChooser.showDialog(null, "Text Color", null);
        if (color != null) {
            new BackgroundColorAction(color).actionPerformed(evt);
        }
    }//GEN-LAST:event_backgroundColorButtonActionPerformed

    private void textColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textColorButtonActionPerformed
        Color color = JColorChooser.showDialog(null, "Text Color", null);
        if (color != null) {
            new StyledEditorKit.ForegroundAction("Color",color).actionPerformed(evt);
        }
    }//GEN-LAST:event_textColorButtonActionPerformed

    private void insertRemoveNumberedListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRemoveNumberedListButtonActionPerformed
        new HTMLEditorKit.InsertHTMLTextAction("Insert Bulleted List", "<ol><li></li></ol>", Tag.BODY, Tag.OL).actionPerformed(evt);
    }//GEN-LAST:event_insertRemoveNumberedListButtonActionPerformed

    private void insertRemoveBulletedListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRemoveBulletedListButtonActionPerformed
        new HTMLEditorKit.InsertHTMLTextAction("Insert Bulleted List", "<ul><li></li></ul>", Tag.BODY, Tag.UL).actionPerformed(evt);
    }//GEN-LAST:event_insertRemoveBulletedListButtonActionPerformed

    private void setToolbarFocusActionListener(JComponent component) {
        Component[] vComponents = component.getComponents();
        for (int i=0; i<vComponents.length; i++) {
            if (vComponents[i] instanceof JButton) {
                JButton button = (JButton)vComponents[i];
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        htmlTextPane.requestFocus();
                    }
                });
            } else if (vComponents[i] instanceof JComboBox) {
                JComboBox comboBox = (JComboBox)vComponents[i];
                comboBox.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent ae) {
                        htmlTextPane.requestFocus();
                    }
                });
            } else if (vComponents[i] instanceof JPanel) {
                JPanel panel = (JPanel)vComponents[i];
                setToolbarFocusActionListener(panel);
            }
        }
    }
/*
    private void setToolbarComponentEnable(JComponent component, boolean enabled) {
        Component[] vComponents = component.getComponents();
        for (int i=0; i<vComponents.length; i++) {
            if (vComponents[i] == sourceButton || vComponents[i] == newButton || vComponents[i] == previewButton || vComponents[i] == aboutButton) {
                return;
            } else if (vComponents[i] instanceof JButton) {
                JButton button = (JButton)vComponents[i];
                button.setEnabled(enabled);
            } else if (vComponents[i] instanceof JComboBox) {
                JComboBox comboBox = (JComboBox)vComponents[i];
                comboBox.setEnabled(enabled);
            } else if (vComponents[i] instanceof JPanel) {
                JPanel panel = (JPanel)vComponents[i];
                setToolbarComponentEnable(panel, enabled);
            }
        }
    }
*/
    public void addContextMenuListener(ContextMenuListener contextMenuListener) {
        contextMenuListeners.add(contextMenuListener);
    }

    public void removeContextMenuListener(ContextMenuListener contextMenuListener) {
        contextMenuListeners.remove(contextMenuListener);
    }

    public void initSpellChecker() {
        try {
            ZipInputStream zipInputStream = null;
            InputStream inputStream = null;
            if (spellCheckDictionaryVersion == SpellCheckDictionaryVersion.CUSTOM) {
                if (customDictionaryFilename == null) {
                    throw new MetaphaseEditorException("The dictionary version has been set to CUSTOM but no custom dictionary file name has been specified.");
                }
                inputStream = new FileInputStream(customDictionaryFilename);
            } else {
                inputStream = this.getClass().getResourceAsStream(spellCheckDictionaryVersion.getFilename());
            }
            zipInputStream = new ZipInputStream(inputStream);
            zipInputStream.getNextEntry();
            dictionary = new SpellDictionaryHashMap(new BufferedReader(new InputStreamReader(zipInputStream)));
            spellChecker = new JTextComponentSpellChecker(dictionary, null, "Check Spelling");
        } catch (FileNotFoundException e) {
            throw new MetaphaseEditorException(e.getMessage(), e);
        } catch (IOException e) {
            throw new MetaphaseEditorException(e.getMessage(), e);
        }
    }

    public void setCustomDictionaryFilename(String customDictionaryFilename) {
        this.customDictionaryFilename = customDictionaryFilename;
    }

    public String getCustomDictionaryFilename() {
        return customDictionaryFilename;
    }

    public void setDictionaryVersion(SpellCheckDictionaryVersion spellCheckDictionaryVersion) {
        this.spellCheckDictionaryVersion = spellCheckDictionaryVersion;

        initSpellChecker();
    }

    public SpellCheckDictionaryVersion getDictionaryVersion() {
        return spellCheckDictionaryVersion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backgroundColorButton;
    private javax.swing.JButton blockJustifyButton;
    private javax.swing.JPanel blockPanel;
    private javax.swing.JButton boldButton;
    private javax.swing.JButton centerJustifyButton;
    private javax.swing.JButton decreaseIndentButton;
    private javax.swing.JComboBox fontComboBox;
    private javax.swing.JComboBox fontSizeComboBox;
    private javax.swing.text.html.HTMLDocument htmlDocument;
    private javax.swing.JTextPane htmlTextPane;
    private javax.swing.JButton increaseIndentButton;
    private javax.swing.JButton insertRemoveBulletedListButton;
    private javax.swing.JButton insertRemoveNumberedListButton;
    private javax.swing.JButton italicButton;
    private javax.swing.JPanel justificationPanel;
    private javax.swing.JButton leftJustifyButton;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JComboBox paragraphFormatComboBox;
    private javax.swing.JButton rightJustifyButton;
    private javax.swing.JButton strikethroughButton;
    private javax.swing.JButton textColorButton;
    private javax.swing.JPanel textEffectPanel;
    private javax.swing.JPanel toolbarPanel;
    private javax.swing.JButton underlineButton;
    // End of variables declaration//GEN-END:variables

    class SubscriptAction extends StyledEditorKit.StyledTextAction {
        public SubscriptAction() {
            super(StyleConstants.Subscript.toString());
        }

        public void actionPerformed(ActionEvent ae)
        {
            JEditorPane editor = getEditor(ae);
            if (editor != null) {
                boolean subscript = (StyleConstants.isSubscript(getStyledEditorKit(editor).getInputAttributes())) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setSubscript(sas, subscript);
                setCharacterAttributes(editor, sas, false);
            }
        }
    }

    class SuperscriptAction extends StyledEditorKit.StyledTextAction
    {
        public SuperscriptAction() {
            super(StyleConstants.Superscript.toString());
        }

        public void actionPerformed(ActionEvent ae) {
            JEditorPane editor = getEditor(ae);
            if (editor != null) {
                StyledEditorKit kit = getStyledEditorKit(editor);
                boolean superscript = (StyleConstants.isSuperscript(kit.getInputAttributes())) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setSuperscript(sas, superscript);
                setCharacterAttributes(editor, sas, false);
            }
        }
    }

    class StrikeThroughAction extends StyledEditorKit.StyledTextAction
    {
        public StrikeThroughAction() {
            super(StyleConstants.StrikeThrough.toString());
        }

        public void actionPerformed(ActionEvent ae) {
            JEditorPane editor = getEditor(ae);
            if (editor != null) {
                StyledEditorKit kit = getStyledEditorKit(editor);
                boolean strikeThrough = (StyleConstants.isStrikeThrough(kit.getInputAttributes())) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setStrikeThrough(sas, strikeThrough);
                setCharacterAttributes(editor, sas, false);
            }
        }
    }

    class BackgroundColorAction extends StyledEditorKit.StyledTextAction
    {
        private Color color;
        public BackgroundColorAction(Color color) {
            super(StyleConstants.StrikeThrough.toString());
            this.color = color;
        }

        public void actionPerformed(ActionEvent ae) {
            JEditorPane editor = getEditor(ae);
            if (editor != null) {
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setBackground(sas, color);
                setCharacterAttributes(editor, sas, false);
            }
        }
    }

    
    class UndoHandler implements UndoableEditListener {
        /**
         * Messaged when the Document has created an edit, the edit is
         * added to <code>undo</code>, an instance of UndoManager.
         */
        public void undoableEditHappened(UndoableEditEvent e) {
            undo.addEdit(e.getEdit());
            undoAction.update();
            redoAction.update();
        }
    }

    class UndoAction extends AbstractAction {
        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {
                undo.undo();
            } catch (CannotUndoException e) {
                throw new MetaphaseEditorException(e.getMessage(), e);
            }
            update();
            redoAction.update();
        }

        protected void update() {
            if(undo.canUndo()) {
                setEnabled(true);
            }else {
                setEnabled(false);
            }
        }
    }

    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {
                undo.redo();
            } catch (CannotRedoException e) {
                throw new MetaphaseEditorException(e.getMessage(), e);
            }
            update();
            undoAction.update();
        }

        protected void update() {
            if(undo.canRedo()) {
                setEnabled(true);
            }else {
                setEnabled(false);
            }
        }
    }

    class HTMLFileFilter extends javax.swing.filechooser.FileFilter{
        public boolean accept(File f){
            return ((f.isDirectory()) ||(f.getName().toLowerCase().indexOf(".htm") > 0));
        }

        public String getDescription(){
            return "html";
        }
    }

    class ParagraphFormatListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index == 0) {
                component.setEnabled(false);
            }
            ParagraphFormat paragraphFormat = (ParagraphFormat)value;
            if (paragraphFormat.getTag() != null) {
                JLabel label = (JLabel)component;
                label.setText("<html><" + paragraphFormat.getTag().toString() + ">" + label.getText() + "</" + paragraphFormat.getTag().toString() + ">");
            }
            return component;
        }        
    }

    class FontListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index == 0) {
                component.setEnabled(false);
            }
            FontItem fontItem = (FontItem)value;
            if (fontItem.getFontName() != null) {
                Font currentFont = component.getFont();
                component.setFont(new Font(fontItem.getFontName(), currentFont.getStyle(), currentFont.getSize()));
            }
            return component;
        }
    }

    class FontSizeListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);            
            if (index == 0) {
                component.setEnabled(false);
            }
            FontSize fontSize = (FontSize)value;
            if (fontSize.getSize() != -1) {
                Font currentFont = component.getFont();
                component.setFont(new Font(currentFont.getName(), currentFont.getStyle(), fontSize.getSize()));
            }
            return component;
        }
    }

    class DefaultEditorMouseMotionListener implements MouseMotionListener {

        public void mouseDragged(MouseEvent me) {
            int pos = htmlTextPane.viewToModel(me.getPoint());

            if (pos >= 0) {
                Element element = htmlDocument.getParagraphElement(pos);
                MutableAttributeSet attributes = new SimpleAttributeSet(element.getAttributes());

                EditorMouseEvent editorMouseEvent = new EditorMouseEvent();
                editorMouseEvent.setNearestParagraphAttributes(attributes);
                for (int i=0; i<editorMouseMotionListeners.size(); i++) {
                    editorMouseMotionListeners.get(i).mouseDragged(editorMouseEvent);
                }
            }
        }

        public void mouseMoved(MouseEvent me) {
            int pos = htmlTextPane.viewToModel(me.getPoint());

            if (pos >= 0) {
                Element element = htmlDocument.getParagraphElement(pos);
                MutableAttributeSet attributes = new SimpleAttributeSet(element.getAttributes());

                EditorMouseEvent editorMouseEvent = new EditorMouseEvent();
                editorMouseEvent.setNearestParagraphAttributes(attributes);
                for (int i=0; i<editorMouseMotionListeners.size(); i++) {
                    editorMouseMotionListeners.get(i).mouseMoved(editorMouseEvent);
                }
            }
        }
    }
}
