package es.tprograms.view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.icons.FlatHelpButtonIcon;
import es.tprograms.controller.ChampionController;
import es.tprograms.controller.DataController;
import es.tprograms.controller.SummonerController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Titovilal
 */
public class View extends javax.swing.JFrame {

    private SummonerController summonerController;
    private DataController dataController;
    private ChampionController championController;
    private List<SubPanelFavs> favPanels;

    public View() {
        FlatDarkLaf.setup();
        initComponents();

    }

    /**
     * Initate the view
     */
    public void initView() {
        FlatHelpButtonIcon buttonIcon = new FlatHelpButtonIcon();
        buttonHelp.setIcon(buttonIcon);
        buttonHelp.setToolTipText("viva españa");
        
        NoScalingIcon searchIcon = new NoScalingIcon(new ImageIcon("resources/static/search.png"));
        buttonSummonerSearch.setIcon(searchIcon);
        buttonChampionSearch.setIcon(searchIcon);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("resources/static/iconTitleBar.png");
        this.setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        textSummoner.requestFocus();
        this.setVisible(true);
    }

    /**
     *
     * Initializes the controllers and sets up the view. Loads the favourite
     * players.
     */
    public void initControllers() {
        summonerController = new SummonerController();
        dataController = new DataController();
        championController = new ChampionController();
        setUpView();
        loadPanelFavs();
    }

    /**
     *
     */
    private void loadPanelFavs() {
        try {
            //Cargar datos y variables
            Map<String, String> favMap = dataController.getFavPlayers();
            JPanel panel = new JPanel();
            //Configuar panel contenedor
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setSize(179, 470);
            panel.setPreferredSize(new Dimension(165, 57 * favMap.size()));
            //Rellenar panel contenedor con subPaneles
            for (Map.Entry<String, String> entry : favMap.entrySet()) {
                SubPanelFavs subPanelFavs = new SubPanelFavs();
                subPanelFavs.setButtonText(entry.getKey(), entry.getValue());
                panel.add(subPanelFavs);
            }
            //Esablecer panel contenedor en la vista
            scrollFavs.setViewportView(panel);
            scrollFavs.getVerticalScrollBar().setUnitIncrement(12);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    private void setUpView() {
        try {
            String currentVersion = dataController.checkVersion();
            labelGameVersion.setText("Lol version: " + currentVersion);

        } catch (IOException ex) {
            labelGameVersion.setText("Error");
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelGameVersion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttonChampionSearch1 = new javax.swing.JButton();
        textChampion = new javax.swing.JTextField();
        buttonChampionSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        buttonLiveGame = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        buttonAddFavourites = new javax.swing.JButton();
        panelFavs = new javax.swing.JPanel();
        scrollFavs = new javax.swing.JScrollPane();
        buttonDeleteFavourites = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboRegion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        textSummoner = new javax.swing.JTextField();
        buttonSummonerSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lol Chest V1.0.0");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(30, 117, 75));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        labelGameVersion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelGameVersion.setForeground(new java.awt.Color(204, 204, 204));
        labelGameVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGameVersion.setText("LoL version: 12.7.3");

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 154, 98));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Welcome to LoL Chests!");

        buttonHelp.setBackground(new java.awt.Color(51, 51, 51));
        buttonHelp.setBorder(null);
        buttonHelp.setBorderPainted(false);
        buttonHelp.setContentAreaFilled(false);
        buttonHelp.setFocusPainted(false);
        buttonHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHelpMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonHelpMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelGameVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(labelGameVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        buttonChampionSearch1.setBackground(new java.awt.Color(30, 117, 75));
        buttonChampionSearch1.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonChampionSearch1.setForeground(new java.awt.Color(35, 35, 35));
        buttonChampionSearch1.setText("Game Builder");
        buttonChampionSearch1.setBorderPainted(false);

        textChampion.setBackground(new java.awt.Color(61, 61, 61));
        textChampion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        textChampion.setForeground(new java.awt.Color(204, 204, 204));
        textChampion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textChampion.setToolTipText("");
        textChampion.setBorder(null);
        textChampion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textChampionKeyPressed(evt);
            }
        });

        buttonChampionSearch.setBackground(new java.awt.Color(30, 117, 75));
        buttonChampionSearch.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonChampionSearch.setForeground(new java.awt.Color(35, 35, 35));
        buttonChampionSearch.setBorderPainted(false);

        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Champion");

        buttonLiveGame.setBackground(new java.awt.Color(51, 51, 51));
        buttonLiveGame.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonLiveGame.setForeground(new java.awt.Color(102, 102, 102));
        buttonLiveGame.setText("Live Game");
        buttonLiveGame.setBorderPainted(false);
        buttonLiveGame.setEnabled(false);
        buttonLiveGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonLiveGameMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChampionSearch1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLiveGame)
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(textChampion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonChampionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(buttonChampionSearch1)
                .addGap(106, 106, 106)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textChampion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(buttonLiveGame))
                    .addComponent(buttonChampionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(43, 43, 43));

        buttonAddFavourites.setBackground(new java.awt.Color(30, 117, 75));
        buttonAddFavourites.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonAddFavourites.setForeground(new java.awt.Color(35, 35, 35));
        buttonAddFavourites.setText("Add to Favourites");
        buttonAddFavourites.setBorderPainted(false);
        buttonAddFavourites.setFocusPainted(false);

        panelFavs.setBackground(new java.awt.Color(43, 43, 43));

        scrollFavs.setBackground(new java.awt.Color(51, 51, 51));
        scrollFavs.setBorder(null);

        javax.swing.GroupLayout panelFavsLayout = new javax.swing.GroupLayout(panelFavs);
        panelFavs.setLayout(panelFavsLayout);
        panelFavsLayout.setHorizontalGroup(
            panelFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollFavs)
        );
        panelFavsLayout.setVerticalGroup(
            panelFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollFavs, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        buttonDeleteFavourites.setBackground(new java.awt.Color(183, 66, 0));
        buttonDeleteFavourites.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonDeleteFavourites.setForeground(new java.awt.Color(35, 35, 35));
        buttonDeleteFavourites.setText("Delete");
        buttonDeleteFavourites.setBorderPainted(false);
        buttonDeleteFavourites.setFocusPainted(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFavs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddFavourites, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonDeleteFavourites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAddFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFavs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(buttonDeleteFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        comboRegion.setBackground(new java.awt.Color(51, 51, 51));
        comboRegion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        comboRegion.setForeground(new java.awt.Color(204, 204, 204));
        comboRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BR1", "EUN1", "EUW1", "JP1", "KR", "LA1", "LA2", "NA1", "OC1", "TR1", "RU" }));
        comboRegion.setSelectedIndex(2);
        comboRegion.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Summoner");

        textSummoner.setBackground(new java.awt.Color(61, 61, 61));
        textSummoner.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        textSummoner.setForeground(new java.awt.Color(204, 204, 204));
        textSummoner.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textSummoner.setToolTipText("");
        textSummoner.setBorder(null);
        textSummoner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSummonerKeyPressed(evt);
            }
        });

        buttonSummonerSearch.setBackground(new java.awt.Color(30, 117, 75));
        buttonSummonerSearch.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonSummonerSearch.setForeground(new java.awt.Color(35, 35, 35));
        buttonSummonerSearch.setBorderPainted(false);
        buttonSummonerSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonSummonerSearchMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SUM");

        jLabel12.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("level");

        jLabel13.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("player elo");

        jLabel8.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("total champs");

        jLabel11.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("chest champs");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(comboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(textSummoner, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSummonerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSummoner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSummonerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboRegion))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel14.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SUM");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textChampionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textChampionKeyPressed
    }//GEN-LAST:event_textChampionKeyPressed

    private void buttonLiveGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLiveGameMousePressed
        //Color for live game active can be 169,169,25
    }//GEN-LAST:event_buttonLiveGameMousePressed

    private void textSummonerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSummonerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSummonerKeyPressed

    private void buttonSummonerSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSummonerSearchMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSummonerSearchMousePressed

    private void buttonHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHelpMouseEntered
        buttonHelp.setBackground(new ColorUIResource(new Color(51, 51, 51)));
    }//GEN-LAST:event_buttonHelpMouseEntered

    private void buttonHelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHelpMousePressed
        String textLabel = labelGameVersion.getText();
        labelGameVersion.setText("Updating All Data");
        labelGameVersion.setForeground(new Color(255, 98, 10));
        int option;
        option = JOptionPane.showOptionDialog(
                null,
                "Errors in data loading? You can update all locally saved "
                + "items to try and fix this error. This may take a phew "
                + "minuts",
                "Help",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Update all local data", "Cancel"},
                "Cancel"
        );
        if (option == JOptionPane.YES_OPTION) {
            try {
                dataController.updateAllData();

                setUpView();
                labelGameVersion.setForeground(new Color(204, 204, 204));
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            labelGameVersion.setText(textLabel);
            labelGameVersion.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_buttonHelpMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddFavourites;
    private javax.swing.JButton buttonChampionSearch;
    private javax.swing.JButton buttonChampionSearch1;
    private javax.swing.JButton buttonDeleteFavourites;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonLiveGame;
    private javax.swing.JButton buttonSummonerSearch;
    private javax.swing.JComboBox<String> comboRegion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labelGameVersion;
    private javax.swing.JPanel panelFavs;
    private javax.swing.JScrollPane scrollFavs;
    private javax.swing.JTextField textChampion;
    private javax.swing.JTextField textSummoner;
    // End of variables declaration//GEN-END:variables

}
