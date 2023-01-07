package es.tprograms.view;

import es.tprograms.model.NoScalingIcon;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.icons.FlatHelpButtonIcon;
import es.tprograms.controller.ChampionController;
import es.tprograms.controller.DataController;
import es.tprograms.controller.SummonerController;
import es.tprograms.model.Summoner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
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
        initControllers();
        loadFavourites();
        this.revalidate();
        this.repaint();
        loadDynamicData();
        loadStaticData();

        loadView();
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
    }

    /**
     *
     */
    private void loadStaticData() {
        loadSearchButtons();
        loadTitleIcon();
        loadHelpButton();
    }

    // <editor-fold defaultstate="collapsed" desc="Static Data Methods"> 
    /**
     *
     */
    private void loadSearchButtons() {
        NoScalingIcon searchIcon = new NoScalingIcon(new ImageIcon("resources/static/search.png"));
        buttonSummonerSearch.setIcon(searchIcon);
        buttonChampionSearch.setIcon(searchIcon);
    }

    /**
     *
     */
    private void loadTitleIcon() {
        Image icon = Toolkit.getDefaultToolkit().getImage("resources/static/iconTitleBar.png");
        this.setIconImage(icon);
    }

    /**
     *
     */
    private void loadHelpButton() {
        FlatHelpButtonIcon buttonIcon = new FlatHelpButtonIcon();
        buttonHelp.setIcon(buttonIcon);
        buttonHelp.setToolTipText("viva españa");
    }
    // </editor-fold>

    /**
     *
     */
    private void loadDynamicData() {
        loadGameVersion();
        loadFavourites();
    }

    // <editor-fold defaultstate="collapsed" desc="Dynamic Data Methods"> 
    /**
     *
     */
    private void loadGameVersion() {
        try {
            String currentVersion = dataController.checkVersion();
            labelGameVersion.setText("Lol version: " + currentVersion);

        }
        catch (IOException ex) {
            labelGameVersion.setText("Error");
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    private void loadFavourites() {
        try {
            Map<String, String> favMap = dataController.getFavPlayers();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setSize(179, 495);
            panel.setPreferredSize(new Dimension(140, 57 * favMap.size()));
            for (Map.Entry<String, String> entry : favMap.entrySet()) {
                SubPanelFavs subPanelFavs = new SubPanelFavs();
                subPanelFavs.setButtonText(entry.getKey(), entry.getValue());
                panel.add(subPanelFavs);
            }
            scrollDisplayFavs.setViewportView(panel);
            scrollDisplayFavs.getVerticalScrollBar().setUnitIncrement(12);
        }
        catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>

    /**
     *
     */
    private void loadView() {
        textSummoner.requestFocus();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        labelGameVersion = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();
        buttonSummonerSearch = new javax.swing.JButton();
        textSummoner = new javax.swing.JTextField();
        labelSummonerSearch = new javax.swing.JLabel();
        comboRegion = new javax.swing.JComboBox<>();
        javax.swing.JPanel panelDisplayChampions = new javax.swing.JPanel();
        panelFavourites = new javax.swing.JPanel();
        buttonAddFavourites = new javax.swing.JButton();
        panelDisplayFavs = new javax.swing.JPanel();
        scrollDisplayFavs = new javax.swing.JScrollPane();
        buttonDeleteFavourites = new javax.swing.JButton();
        panelStats = new javax.swing.JPanel();
        panelChampionStats = new javax.swing.JPanel();
        panelChampionIcon = new javax.swing.JPanel();
        labelChampionIcon = new javax.swing.JLabel();
        labelChampionName = new javax.swing.JLabel();
        buttonChampionSearch1 = new javax.swing.JButton();
        labelChampionPoints = new javax.swing.JLabel();
        panelSummonerIcon = new javax.swing.JPanel();
        labelSummonerIcon = new javax.swing.JLabel();
        labelSummonerName = new javax.swing.JLabel();
        buttonLiveGame = new javax.swing.JButton();
        LabelSummonerTier = new javax.swing.JLabel();
        labelSummonerLevel = new javax.swing.JLabel();
        panelChampionSearcher = new javax.swing.JPanel();
        textChampion = new javax.swing.JTextField();
        buttonChampionSearch = new javax.swing.JButton();
        labelChampionSearch = new javax.swing.JLabel();
        labelAvailabelChampions = new javax.swing.JLabel();
        comboSort = new javax.swing.JComboBox<>();
        labelSort = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lol Chest V1.0.0");
        setResizable(false);

        panelBackground.setBackground(new java.awt.Color(30, 117, 75));

        panelTitle.setBackground(new java.awt.Color(51, 51, 51));

        labelGameVersion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelGameVersion.setForeground(new java.awt.Color(204, 204, 204));
        labelGameVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGameVersion.setText("LoL version: 12.7.3");

        labelTitle.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(39, 154, 98));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Welcome to LoL Chests!");

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

        buttonSummonerSearch.setBackground(new java.awt.Color(30, 117, 75));
        buttonSummonerSearch.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonSummonerSearch.setForeground(new java.awt.Color(35, 35, 35));
        buttonSummonerSearch.setBorderPainted(false);
        buttonSummonerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSummonerSearchActionPerformed(evt);
            }
        });

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

        labelSummonerSearch.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelSummonerSearch.setForeground(new java.awt.Color(204, 204, 204));
        labelSummonerSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSummonerSearch.setText("Summoner");

        comboRegion.setBackground(new java.awt.Color(51, 51, 51));
        comboRegion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        comboRegion.setForeground(new java.awt.Color(204, 204, 204));
        comboRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BR1", "EUN1", "EUW1", "JP1", "KR", "LA1", "LA2", "NA1", "OC1", "TR1", "RU" }));
        comboRegion.setBorder(null);

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelGameVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSummonerSearch)
                .addGap(18, 18, 18)
                .addComponent(textSummoner, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSummonerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSummonerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textSummoner)
                    .addComponent(comboRegion)
                    .addComponent(labelGameVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTitleLayout.createSequentialGroup()
                        .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSummonerSearch)
                            .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelDisplayChampions.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelDisplayChampionsLayout = new javax.swing.GroupLayout(panelDisplayChampions);
        panelDisplayChampions.setLayout(panelDisplayChampionsLayout);
        panelDisplayChampionsLayout.setHorizontalGroup(
            panelDisplayChampionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDisplayChampionsLayout.setVerticalGroup(
            panelDisplayChampionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelFavourites.setBackground(new java.awt.Color(43, 43, 43));

        buttonAddFavourites.setBackground(new java.awt.Color(30, 117, 75));
        buttonAddFavourites.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonAddFavourites.setForeground(new java.awt.Color(35, 35, 35));
        buttonAddFavourites.setText("Add to Favourites");
        buttonAddFavourites.setBorderPainted(false);
        buttonAddFavourites.setEnabled(false);
        buttonAddFavourites.setFocusPainted(false);

        panelDisplayFavs.setBackground(new java.awt.Color(43, 43, 43));

        scrollDisplayFavs.setBackground(new java.awt.Color(51, 51, 51));
        scrollDisplayFavs.setBorder(null);

        javax.swing.GroupLayout panelDisplayFavsLayout = new javax.swing.GroupLayout(panelDisplayFavs);
        panelDisplayFavs.setLayout(panelDisplayFavsLayout);
        panelDisplayFavsLayout.setHorizontalGroup(
            panelDisplayFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollDisplayFavs)
        );
        panelDisplayFavsLayout.setVerticalGroup(
            panelDisplayFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollDisplayFavs, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        buttonDeleteFavourites.setBackground(new java.awt.Color(183, 66, 0));
        buttonDeleteFavourites.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonDeleteFavourites.setForeground(new java.awt.Color(35, 35, 35));
        buttonDeleteFavourites.setText("Delete");
        buttonDeleteFavourites.setBorderPainted(false);
        buttonDeleteFavourites.setEnabled(false);
        buttonDeleteFavourites.setFocusPainted(false);

        javax.swing.GroupLayout panelFavouritesLayout = new javax.swing.GroupLayout(panelFavourites);
        panelFavourites.setLayout(panelFavouritesLayout);
        panelFavouritesLayout.setHorizontalGroup(
            panelFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDisplayFavs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFavouritesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddFavourites, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonDeleteFavourites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelFavouritesLayout.setVerticalGroup(
            panelFavouritesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFavouritesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAddFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDisplayFavs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(buttonDeleteFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelStats.setBackground(new java.awt.Color(51, 51, 51));

        panelChampionStats.setBackground(new java.awt.Color(51, 51, 51));

        labelChampionIcon.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelChampionIcon.setForeground(new java.awt.Color(204, 204, 204));
        labelChampionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelChampionIconLayout = new javax.swing.GroupLayout(panelChampionIcon);
        panelChampionIcon.setLayout(panelChampionIconLayout);
        panelChampionIconLayout.setHorizontalGroup(
            panelChampionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelChampionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );
        panelChampionIconLayout.setVerticalGroup(
            panelChampionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelChampionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        labelChampionName.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelChampionName.setForeground(new java.awt.Color(204, 204, 204));
        labelChampionName.setText("Nidalee");

        buttonChampionSearch1.setBackground(new java.awt.Color(30, 117, 75));
        buttonChampionSearch1.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        buttonChampionSearch1.setForeground(new java.awt.Color(35, 35, 35));
        buttonChampionSearch1.setText("Game Builder");
        buttonChampionSearch1.setBorderPainted(false);
        buttonChampionSearch1.setEnabled(false);

        labelChampionPoints.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelChampionPoints.setForeground(new java.awt.Color(204, 204, 204));
        labelChampionPoints.setText("768K Points (level 7)");

        javax.swing.GroupLayout panelChampionStatsLayout = new javax.swing.GroupLayout(panelChampionStats);
        panelChampionStats.setLayout(panelChampionStatsLayout);
        panelChampionStatsLayout.setHorizontalGroup(
            panelChampionStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChampionStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelChampionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelChampionStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChampionStatsLayout.createSequentialGroup()
                        .addComponent(labelChampionName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChampionSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelChampionPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelChampionStatsLayout.setVerticalGroup(
            panelChampionStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChampionStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChampionStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChampionStatsLayout.createSequentialGroup()
                        .addGroup(panelChampionStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelChampionName)
                            .addComponent(buttonChampionSearch1))
                        .addGap(10, 10, 10)
                        .addComponent(labelChampionPoints))
                    .addComponent(panelChampionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelSummonerIcon.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelSummonerIcon.setForeground(new java.awt.Color(204, 204, 204));
        labelSummonerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelSummonerIconLayout = new javax.swing.GroupLayout(panelSummonerIcon);
        panelSummonerIcon.setLayout(panelSummonerIconLayout);
        panelSummonerIconLayout.setHorizontalGroup(
            panelSummonerIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSummonerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );
        panelSummonerIconLayout.setVerticalGroup(
            panelSummonerIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSummonerIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        labelSummonerName.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelSummonerName.setForeground(new java.awt.Color(204, 204, 204));
        labelSummonerName.setText("Titovilal (euw)");

        buttonLiveGame.setBackground(new java.awt.Color(30, 117, 75));
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

        LabelSummonerTier.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        LabelSummonerTier.setForeground(new java.awt.Color(204, 204, 204));
        LabelSummonerTier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSummonerTier.setText("Gold 4");

        labelSummonerLevel.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelSummonerLevel.setForeground(new java.awt.Color(204, 204, 204));
        labelSummonerLevel.setText("Level not available");

        javax.swing.GroupLayout panelStatsLayout = new javax.swing.GroupLayout(panelStats);
        panelStats.setLayout(panelStatsLayout);
        panelStatsLayout.setHorizontalGroup(
            panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelChampionStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSummonerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSummonerName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addGroup(panelStatsLayout.createSequentialGroup()
                        .addComponent(labelSummonerLevel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelSummonerTier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLiveGame, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelStatsLayout.setVerticalGroup(
            panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelChampionStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStatsLayout.createSequentialGroup()
                        .addGroup(panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSummonerName)
                            .addComponent(buttonLiveGame))
                        .addGap(10, 10, 10)
                        .addGroup(panelStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSummonerTier)
                            .addComponent(labelSummonerLevel)))
                    .addComponent(panelSummonerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelChampionSearcher.setBackground(new java.awt.Color(51, 51, 51));

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
        buttonChampionSearch.setEnabled(false);

        labelChampionSearch.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelChampionSearch.setForeground(new java.awt.Color(204, 204, 204));
        labelChampionSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChampionSearch.setText("Champion");

        labelAvailabelChampions.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelAvailabelChampions.setForeground(new java.awt.Color(204, 204, 204));
        labelAvailabelChampions.setText("Avaliable champions: 89");

        comboSort.setBackground(new java.awt.Color(51, 51, 51));
        comboSort.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        comboSort.setForeground(new java.awt.Color(204, 204, 204));
        comboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "name", "mastery", "points" }));
        comboSort.setBorder(null);

        labelSort.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        labelSort.setForeground(new java.awt.Color(204, 204, 204));
        labelSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSort.setText("Sort by");

        javax.swing.GroupLayout panelChampionSearcherLayout = new javax.swing.GroupLayout(panelChampionSearcher);
        panelChampionSearcher.setLayout(panelChampionSearcherLayout);
        panelChampionSearcherLayout.setHorizontalGroup(
            panelChampionSearcherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChampionSearcherLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelAvailabelChampions, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(139, 139, 139)
                .addComponent(labelChampionSearch)
                .addGap(18, 18, 18)
                .addComponent(textChampion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonChampionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSort)
                .addGap(2, 2, 2)
                .addComponent(comboSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelChampionSearcherLayout.setVerticalGroup(
            panelChampionSearcherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChampionSearcherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChampionSearcherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChampionSearcherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboSort)
                        .addComponent(labelSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelAvailabelChampions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textChampion)
                    .addGroup(panelChampionSearcherLayout.createSequentialGroup()
                        .addComponent(buttonChampionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelChampionSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(panelFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDisplayChampions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelChampionSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelFavourites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBackgroundLayout.createSequentialGroup()
                        .addComponent(panelStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(panelChampionSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panelDisplayChampions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textChampionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textChampionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonSummonerSearch.doClick();
        }
    }//GEN-LAST:event_textChampionKeyPressed

    private void textSummonerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSummonerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonSummonerSearch.doClick();
        }
    }//GEN-LAST:event_textSummonerKeyPressed

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

                loadGameVersion();
                labelGameVersion.setForeground(new Color(204, 204, 204));
            }
            catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            labelGameVersion.setText(textLabel);
            labelGameVersion.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_buttonHelpMousePressed

    private void buttonLiveGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLiveGameMousePressed
        //Color for live game active can be 169,169,25
    }//GEN-LAST:event_buttonLiveGameMousePressed

    private void buttonSummonerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSummonerSearchActionPerformed
        if (textSummoner.getText().isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "The summoner doesn't exist",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String region = (String) comboRegion.getSelectedItem();
            String name = textSummoner.getText();
            Summoner summoner;
            try {
                summoner = summonerController.getSummonerByName(region, name);
                System.out.println(region);
                System.out.println(name);
                System.out.println(summoner);
                if (summoner == null) {
                    JOptionPane.showMessageDialog(null,
                            "The summoner doesn't exist",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    loadSummonerStats(summoner);
//                    loadAvaliableChampions();
                }

            }
            catch (IOException | InterruptedException | URISyntaxException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonSummonerSearchActionPerformed

    /**
     *
     * @param summoner
     */
    private void loadSummonerStats(Summoner summoner) {
        labelSummonerName.setText(summoner.getName());
        labelSummonerLevel.setText(String.valueOf(summoner.getLevel()));
        System.out.println(summoner.getName());
        System.out.println(summoner.getLevel());

        NoScalingIcon icon;
        icon = summonerController.getSummonerIcon(summoner.getProfileIconId());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSummonerTier;
    private javax.swing.JButton buttonAddFavourites;
    private javax.swing.JButton buttonChampionSearch;
    private javax.swing.JButton buttonChampionSearch1;
    private javax.swing.JButton buttonDeleteFavourites;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonLiveGame;
    private javax.swing.JButton buttonSummonerSearch;
    private javax.swing.JComboBox<String> comboRegion;
    private javax.swing.JComboBox<String> comboSort;
    private javax.swing.JLabel labelAvailabelChampions;
    private javax.swing.JLabel labelChampionIcon;
    private javax.swing.JLabel labelChampionName;
    private javax.swing.JLabel labelChampionPoints;
    private javax.swing.JLabel labelChampionSearch;
    private javax.swing.JLabel labelGameVersion;
    private javax.swing.JLabel labelSort;
    private javax.swing.JLabel labelSummonerIcon;
    private javax.swing.JLabel labelSummonerLevel;
    private javax.swing.JLabel labelSummonerName;
    private javax.swing.JLabel labelSummonerSearch;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelChampionIcon;
    private javax.swing.JPanel panelChampionSearcher;
    private javax.swing.JPanel panelChampionStats;
    private javax.swing.JPanel panelDisplayFavs;
    private javax.swing.JPanel panelFavourites;
    private javax.swing.JPanel panelStats;
    private javax.swing.JPanel panelSummonerIcon;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JScrollPane scrollDisplayFavs;
    private javax.swing.JTextField textChampion;
    private javax.swing.JTextField textSummoner;
    // End of variables declaration//GEN-END:variables

}
