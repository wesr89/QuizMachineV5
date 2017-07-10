
// Wesley Redmond - D14125468 
// Java Christmas Assignment
// DT036A / 3

package quizmachinev5;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.applet.Main;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;



//@author wredmond

public class QuizMachinev5 extends JFrame implements ActionListener {
    
    // ------------------------- game frame code -------------------------
    
    // create objects for use on the game frame
    
    JFrame home = new JFrame("Home");
    
    // set up the top label
    JPanel jpTitle = new JPanel();
    JLabel title = new JLabel("Quiz Machine v4");
    
    // ---------- set up the question panel
    JPanel jpQuestion = new JPanel(new GridLayout(9,1));
    
    // create new label objects for the jpQuestion panel
    JLabel questionLabel = new JLabel("Question:");
    JLabel question = new JLabel("Placeholder for question string");
    JLabel scoreLabel = new JLabel("Score: 7");
    JTextArea questionArea = new JTextArea("Placeholder text for question");
    
    JLabel blankLabel1 = new JLabel();
    JLabel blankLabel2 = new JLabel();
    JLabel blankLabel3 = new JLabel();
    JLabel highScoreLabel = new JLabel();
    JLabel blankLabel5 = new JLabel();
    JLabel blankLabel6 = new JLabel();
    
     // create new button  objects for the jpQuestion panel
    JButton button1 = new JButton("View High Score");
    JButton button2 = new JButton("File");
    
    
     // ---------- set up the answer panel
    JPanel jpAnswer = new JPanel(new GridLayout(9,1));
    
    // create new label objects for the jpAnswers panel
    JLabel answerLabel = new JLabel("Answer");
    
    JLabel blankLabel7 = new JLabel();
    JLabel blankLabel8 = new JLabel();
    JLabel blankLabel9 = new JLabel();
    JLabel blankLabel10 = new JLabel();
    JLabel blankLabel11 = new JLabel();
    
    // create new button objects for the jpAnswers panel
    JButton submit = new JButton("Submit");
    JButton logOut = new JButton("Log Out");
    JButton quit = new JButton("Quit");
    
    // create new radio button objects for the jpAnswers panel
    private JRadioButton jrbButton1 = new JRadioButton("Option 1");
    private JRadioButton jrbButton2 = new JRadioButton("Option 2");
    private JRadioButton  jrbButton3 = new JRadioButton("Option 3");
    private JRadioButton  jrbButton4 = new JRadioButton("Option 4");

// create a panel to group the radio butons
    ButtonGroup group = new ButtonGroup();
    
    // ------------------------- game frame code -------------------------
    
        
        // ------------------------- login frame code -------------------------
         
         // create objects for use on the login frame
         
         // create a login frame frame
        private JFrame loginFrame = new JFrame();
        
        // create a panel to hold the top elements and give it a grid layout
        JPanel  jpLogin = new JPanel(new GridLayout(1,2));
        
        // create label and textfield
        JLabel panel2label = new JLabel("Enter username");
        JTextField txtUsername = new JTextField("Username");
        
        // create a panel to hold the bottom elements and give it a grid layout
        JPanel buttonAndText = new JPanel(new GridLayout(2,1));
        
        // create button and textarea
        JButton cmdLogin = new JButton("Log in!");
        JTextArea info = new JTextArea("Enter your username above. \nIf you've logged in before," + 
                " your high score will be loaded. \nOtherwise, a new profile will be created");
        
        // ------------------------- end login frame code -------------------------
        
        // ------------------------- initialise common variables -------------------------
        
        /*
        this variable will hold the high score. 
        It will pass the high score between the user's text file and back
         */
        
        int highScore = 0; 
        
        /*
        this variable will hold the current game score. 
        It will pass the score between the current game and the user's high score
        */
        
        int score = 0;
        
        /*
        this variable will hold the user's name. 
        It will pass the user's name between frames, and determine
        which file will be opened each time the Login button is pressed
        */
        
        String user;
        
        /*
        this array will be used to hold the questions, which will be 
        outputted to the user
        */
        
         String strQuestion[] = { 
             
             "In which movie would you hear the song 'Hakuna Matata'?", // 0
             "In which television show would you find characters named Homer, Marge, Bart and Lisa?", // 01
             "Which type of scientist studies and forecasts the weather?", // 02
             "What color would you get if you mixed red and yellow together?", // 03
             "There are movies based on the Harry Potter series.", // 04
             "Which memorable historical event took place November 22, 1963?",   // 05
              "What date was D-Day?", // 06
              "In what year did Man Utd last win the treble?", // 07
              "How many colours in the rainbow?", // 08
              "Number of Dublin Football All Ireland Football titles?", // 09
              "What is the capital of Australia?", // 10
              "What is the currency of Poland?" , // 11
              "What is the currency of Thailand?" , // 12
              "What is the largest mountain range in the world?" , // 13
              "What is the square root of 25?", // 14
              "How many Oscars has Leondardo Di Caprio won?", // 15
              "How many Harry Potter books have been published?", // 16
              "Who won the Premier League 2015/2016?", // 17
              "Which of the following movies did Tom Cruise not star in?", // 18
              "What is the largest sea in the world?", // 19
              "What is the largest country in the world?", // 20
              "Who are the current All Ireland Hurling champions?", // 21
              "Where is the Van Gogh Musuem?" // 22
                 
         };
         
         
         /* 
         The int r will have a random number assigned to it
         in order to change the quesrtion string and set the label
         for the answer radio buttons
         */
         int r = 0;
         
         /* 
         The int temp is used to temporarily hold the integer score,
         which holds the value of the user's current score.
         It's needed because when a user gets a question wrong and 
         logs out immediately, the highScore checks the score and decides
         whether or not to update the file.
         The reason it's added is because the score must be set back to 0 when 
         a question is gotten wrong, so temp reassigns the score back to score 
         if the user logs out immediately
         */
         int temp = 0;
        
        // ------------------------- end initialise common variables -------------------------
        
        
        
        // ------------------------- main method -------------------------
         
    public static void main(String[] args) throws IOException {
        
        QuizMachinev5 build4 = new QuizMachinev5();
        
    } 
        // ------------------------- end main method -------------------------
    
    
    
    QuizMachinev5() {
        
        // ------------------------- game frame -------------------------
        
       /*
        The following section of code adds content to the panels
        in the main game frame, and adds the content to those panels.
        It also styles them.
        */
        
        // add the title, question and answer panel to the frame
        home.add(jpTitle, BorderLayout.PAGE_START); // top
        home.add(jpQuestion, BorderLayout.WEST); // left
        home.add(jpAnswer, BorderLayout.EAST); // right
       
        // add the title label to the title panel
        // set it to visible, and make it red
        jpTitle.add(title);
        jpTitle.setOpaque(true);
        jpTitle.setBackground(Color.red);
        
        // add the question label to the question panel
        // set it to visible and make it white
        jpQuestion.add(questionLabel);
        questionLabel.setOpaque(true);
        questionLabel.setBackground(Color.WHITE);
        
        // set the question's preferred size
        questionArea.setPreferredSize(new Dimension(250, 45));
        
        // add the question, blank labels, score and buttons to the question panel
        // also set some of them to be visible and coloured, to make the GUI nicer
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setOpaque(true);
        questionArea.setEditable(false);
        questionArea.setBackground(Color.CYAN);
        
        jpQuestion.add(questionArea);
        
        jpQuestion.add(blankLabel1);
        jpQuestion.add(blankLabel2);
        jpQuestion.add(blankLabel3);
        jpQuestion.add(scoreLabel);
        jpQuestion.add(highScoreLabel);
        
        jpQuestion.add(button1);
        jpQuestion.add(button2);
        
        // add the answer header label, set it visible and white to match the question
        jpAnswer.add(answerLabel);
        answerLabel.setOpaque(true);
        answerLabel.setBackground(Color.white);
        
        // add the radio buttons to a group 
        // and set the selected button by default
        jrbButton1.setSelected(true);
        group.add(jrbButton1);
        group.add(jrbButton2);
        group.add(jrbButton3);
        group.add(jrbButton4);
        
        // add the radio buttons to the form
        jpAnswer.add(jrbButton1);
        jpAnswer.add(jrbButton2);
        jpAnswer.add(jrbButton3);
        jpAnswer.add(jrbButton4);
        
        // set the size of the submit button
        submit.setPreferredSize(new Dimension(250, 40));
        
        // add the rest of the labels and buttons
        jpAnswer.add(submit);
        jpAnswer.add(blankLabel7);
        jpAnswer.add(logOut);
        jpAnswer.add(quit);
        
        // set defaults
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setVisible(false);
        
        // populate the radio buttons with answers      
        questionArea.setText(strQuestion[0] );
        jrbButton1.setText("The Lion King");
        jrbButton2.setText("Cinderella");
        jrbButton3.setText("Beauty and the Beast");
        jrbButton4.setText("Hercules");
        
        // ------------------------- end game frame -------------------------
        
        // ------------------------- login frame -------------------------
                     
        /*
        The following section of code adds content to the panels
        in the login frame, and adds the content to those panels.
        It also styles them.
        */          
        
        loginFrame.add(jpLogin, BorderLayout.NORTH); // top
        loginFrame.add(buttonAndText, BorderLayout.SOUTH); // left
        
        jpLogin.add(panel2label);
        jpLogin.add(txtUsername);
        
        buttonAndText.add(cmdLogin);
        buttonAndText.add(info);
        info.setOpaque(false);
        info.setEditable(false);
        
        // set defaults
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ------------------------- end login frame -------------------------
        
        // ------------------------- add ActionListeners -------------------------
        
        // add ActionListeners
        submit.addActionListener(this);
        quit.addActionListener(this);
        jrbButton1.addActionListener(this);
        button2.addActionListener(this);
        cmdLogin.addActionListener(this);
        logOut.addActionListener(this);
        button1.addActionListener(this);
        
        // ------------------------- end ActionListeners -------------------------
        
    }
    
     // ------------------------- button code -------------------------
    
    @Override // code what the buttons do here
    public void actionPerformed(ActionEvent e) {
        
        // ------------------------- submit button code -------------------------
        
        if (e.getSource() == submit) {
            
            /*
            The following section of code checks whether or not the 
            CORRECT radio button is checked when the submit button is 
            pressed, based on which question has been loaded from 
            the strQuestion array. If it's correct:
                - print a console message
                - generate a new random int for the next question
                - add to the current 'score' variable
                - update the text in the score label
                - play a sound
            */
            
             if (jrbButton1.isSelected() && r == 0) {
                 
                System.out.println("Correct!");
                r = (int)(Math.random() * strQuestion.length);
                questionArea.setText(strQuestion[r]);
                score++;
                scoreLabel.setText("Score: " + score);
                sound();
               
            } else if (jrbButton1.isSelected() && r == 1) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             } else if (jrbButton1.isSelected() && r == 2) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             } else if (jrbButton4.isSelected() && r == 3) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             } else if (jrbButton1.isSelected() && r == 4) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             } else if (jrbButton1.isSelected() && r == 5) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 6) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 7) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 8) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 9) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton4.isSelected() && r == 10) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 11) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 12) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton4.isSelected() && r == 13) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 14) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 15) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 16) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 17) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 18) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 19) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 20) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton2.isSelected() && r == 21) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else if (jrbButton3.isSelected() && r == 22) {
                 
                 System.out.println("Correct!");
                 r = (int)(Math.random() * strQuestion.length);
                 questionArea.setText(strQuestion[r]);
                 score++;
                scoreLabel.setText("Score: " + score);
                sound();
                
             }  else {
                 
                 
                  /*
            
                 The following block of code is ran when the correct radio button is
                 NOT selected when the submit button is pressed, based on which 
                 question has been loaded from the strQuestion array. If it's wrong: 
                    - a sound will play
                    - the highScore will be checked and updated
                    - the labels will be updated
                    - the files holding the highScores will be updated
                 
                 */
                 
                 // declare an inputStream
                 InputStream music;
                 
                 try { // play an audio file, which has been stored in the project directory
                     // source: https://mukeshscience.wordpress.com/2014/05/26/adding-audio-to-java/
                     music=new FileInputStream(new File("incorrectSound.wav"));
                     AudioStream audios=new AudioStream(music);
                     AudioPlayer.player.start(audios);
                 }
                 catch(Exception ef) {
                     JOptionPane.showMessageDialog(null,ef.getLocalizedMessage());
                 } 
                 
                 
                 if (score  > highScore) {
                     System.out.println("Score is greater than highScore!");
                 }
                 
                 else {
                     System.out.println("Score is not greater than highScore");
                 }
                 
                 try {
                     java.io.File file = new java.io.File(user + ".txt");
                     java.io.PrintWriter output = new java.io.PrintWriter(file);
                     //Scanner  input = new Scanner(file);

// write output to the file
                     
                    // if the score is higher than the current highScore,
                    // update the file, and score label
                     if (score > highScore) {
                         
                         output.println(user + " " + score);
                         output.close();
                         highScoreLabel.setText("Name: " + user + " High Score: " + score); 
                         
        } else {
                    // if not, keep the current highScore without updating
                    // update the label
                         
                         output.println(user + " " + highScore);
                         output.close();
                         highScoreLabel.setText("Name: " + user + " High Score: " + highScore); 
                        
                         
                         
        }
                     
                     
        
        // generate a new random int r to generate a new question from strQuestion
        r = (int)(Math.random() * strQuestion.length);
        questionArea.setText(strQuestion[r]);
        
        // select the first button again (re-initialise frame)
        jrbButton1.setSelected(true);
        
         // show a message dialog to explain the answer is wrong
        JOptionPane.showMessageDialog(this, "Incorrect Answer. \n" + 
                     "Your score was " + score + "\n\nStarting new game...");
        
        
        /* 
        assign the current score to the temp variable
        this will be used later, if the user logs out immediately 
        after setting a new high score
        */
        temp = score;
        
        // reset the current score
        score = 0;  
        
      
        // update the score label
        scoreLabel.setText("Score: " + 0);
       } 
                 catch (IOException ex){
                     ex.printStackTrace();
                 }  
                
             }
             
             /*
             the following switch statement is used to check which random
             integer has been generated for use in the strQuestion array,
             and populates the radio buttons with possible answers 
             */
             
             switch (r) {
                 case 0:
                     jrbButton1.setText("The Lion King");
                     jrbButton2.setText("Cinderella");
                     jrbButton3.setText("Beauty and the Beast");
                     jrbButton4.setText("Hercules");
                     break;
                 case 1:
                     jrbButton1.setText("The Simpsons");
                     jrbButton2.setText("Friends");
                     jrbButton3.setText("Seinfeld");
                     jrbButton4.setText("Eastenders");
                     break;
                  case 2:
                     jrbButton1.setText("Meteorologist");
                     jrbButton2.setText("Astrologist");
                     jrbButton3.setText("Astronomer");
                     jrbButton4.setText("Biologist");
                     break;
                  case 3:
                     jrbButton1.setText("Pink");
                     jrbButton2.setText("Blue");
                     jrbButton3.setText("Gray");
                     jrbButton4.setText("Orange");
                     break;
                  case 4:
                     jrbButton1.setText("Yes");
                     jrbButton2.setText("No");
                     jrbButton3.setText("Maybe");
                     jrbButton4.setText("I don't know");
                     break;
                  case 5:
                     jrbButton1.setText("JFK's assassination");
                     jrbButton2.setText("The bombing of Hiroshima");
                     jrbButton3.setText("The Great Depression began");
                     jrbButton4.setText("The start of World War 1");
                     break;
                  case 6:
                     jrbButton1.setText("6 May 1944");
                     jrbButton2.setText("6 June 1944");
                     jrbButton3.setText("6 July 1944");
                     jrbButton4.setText("6 August 1944");
                     break;
                  case 7:
                     jrbButton1.setText("1996");
                     jrbButton2.setText("1997");
                     jrbButton3.setText("1999");
                     jrbButton4.setText("2000");
                     break;
                   case 8:
                     jrbButton1.setText("5");
                     jrbButton2.setText("6");
                     jrbButton3.setText("7");
                     jrbButton4.setText("9");
                     break;
                  case 9:
                     jrbButton1.setText("16");
                     jrbButton2.setText("21");
                     jrbButton3.setText("26");
                     jrbButton4.setText("31");
                     break;
                  case 10:
                     jrbButton1.setText("Sydney");
                     jrbButton2.setText("Melbourne");
                     jrbButton3.setText("Perth");
                     jrbButton4.setText("Canberra");
                     break;
                  case 11:
                     jrbButton1.setText("Baht");
                     jrbButton2.setText("Euro");
                     jrbButton3.setText("Zloty");
                     jrbButton4.setText("Ruble");
                     break;
                 case 12:
                     jrbButton1.setText("Euro");
                     jrbButton2.setText("Baht");
                     jrbButton3.setText("Zloty");
                     jrbButton4.setText("Ruble");
                     break;
                 case 13:
                     jrbButton1.setText("The Rockies");
                     jrbButton2.setText("The Alps");
                     jrbButton3.setText("The Himalayas");
                     jrbButton4.setText("The Andes");
                     break;
                  case 14:
                     jrbButton1.setText("1");
                     jrbButton2.setText("25");
                     jrbButton3.setText("5");
                     jrbButton4.setText("4.5");
                     break;
                 case 15:
                     jrbButton1.setText("0");
                     jrbButton2.setText("1");
                     jrbButton3.setText("3");
                     jrbButton4.setText("4");
                     break;
                case 16:
                     jrbButton1.setText("5");
                     jrbButton2.setText("6");
                     jrbButton3.setText("7");
                     jrbButton4.setText("8");
                     break;
                 case 17:
                     jrbButton1.setText("Man Utd");
                     jrbButton2.setText("Leicester City");
                     jrbButton3.setText("Chelsea");
                     jrbButton4.setText("Liverpool");
                     break;
                 case 18:
                     jrbButton1.setText("A Few Good Men");
                     jrbButton2.setText("Silence of the Lambs");
                     jrbButton3.setText("Rain Man");
                     jrbButton4.setText("Mission Impossible");
                     break;
                   case 19:
                     jrbButton1.setText("Atlantic Ocean");
                     jrbButton2.setText("Pacific Ocean");
                     jrbButton3.setText("Carribean Sea");
                     jrbButton4.setText("The Black Sea");
                     break;
                  case 20:
                     jrbButton1.setText("China");
                     jrbButton2.setText("Iran");
                     jrbButton3.setText("Russia");
                     jrbButton4.setText("Nigeria");
                     break;
                  case 21:
                     jrbButton1.setText("Kildare");
                     jrbButton2.setText("Tipperary");
                     jrbButton3.setText("Cork");
                     jrbButton4.setText("Galway");
                     break;
                  case 22:
                     jrbButton1.setText("Munich");
                     jrbButton2.setText("Prague");
                     jrbButton3.setText("Amsterdam");
                     jrbButton4.setText("Paris");
                     break;
                      
             } 
           
        } 

// ------------------------- end submit button code -------------------------  
        
// ------------------------- quit button code -------------------------       
        
        else if (e.getSource() == quit) {
            
           // quit without any changes being saved
           System.exit(0);
           
        }
// ------------------------- end quit button code ------------------------- 
        
// ------------------------- high score button code ------------------------- 
        
        else if (e.getSource() == button1) {
            
            
            // play a sound
            InputStream music;
            try{
                music = new FileInputStream(new File("beep5.wav"));
                AudioStream audios=new AudioStream(music);
                AudioPlayer.player.start(audios);
            }

            catch(Exception ef){
                JOptionPane.showMessageDialog(null,ef.getLocalizedMessage());
            }   
            
            /*
            the following section of code imports the text file based on the user's name
            which they inputted on the login screen. It checks for highScore and 
            updates the label, then shows a message box
            */
            java.io.File file = new java.io.File(user + ".txt");
      
            try {
                Scanner  input = new Scanner(file);
                
                if (file.exists()) { // if the file exists, read its contents
                    
                    String loaded = input.next();
                    highScore = input.nextInt();
                    JOptionPane.showMessageDialog(this, user + ", your high score is " + highScore
                    + "\nand your score is currently: " + score);
                    
                    input.close();
                }
              
            } catch (Exception ex ) {
                // n/a
            }
            
        } 
        
        // ------------------------- end high score button code ------------------------- 
        
        // ------------------------- login button code ------------------------- 
        
        else if (e.getSource() == cmdLogin) { 
            
            // play a sound on login
            InputStream music;
            try{
                music = new FileInputStream(new File("loginSound.wav"));
                AudioStream audios = new AudioStream(music);
                AudioPlayer.player.start(audios);
            }
            catch (Exception ef) {
                JOptionPane.showMessageDialog(null,ef.getLocalizedMessage());
            }   
            
            // reset the score and labal to 0, and update the user's name on the label
            score = 0;
            user = txtUsername.getText();
            scoreLabel.setText("Score: " + score);
            
           /*
            the following section of code imports the text file based on the user's name
            which they inputted on the login screen. It checks for highScore and 
            updates the label, then shows a message box
           */
            java.io.File file = new java.io.File(user + ".txt");
      
            try {
                Scanner  input = new Scanner(file);
              
               if (file.exists()) {
                   JOptionPane.showMessageDialog(this, "Welcome back " + user + 
                           ", you have logged in successfully!");
                   java.io.File load = new java.io.File(user + ".txt");
            
           /*
            the following section of code imports the text file based on the user's name
            which they inputted on the login screen. It checks for highScore and 
            updates the label, then shows a message box to say confirm a new user has been created,
            or a user has logged back in
           */
                String loaded = input.next();
                highScore = input.nextInt();
                highScoreLabel.setText("Name: " + loaded + " " + "High Score: " + highScore);
                input.close();
               }
            } catch (Exception ex ) {
                JOptionPane.showMessageDialog(this, "Thank you " + user + 
                        ", you have successfully created your profile");
            }
      
       if (file.exists()) {
           // do nothing at all
       }
       else
           // update the highScore label to 0 since the user is new
           highScoreLabel.setText("Name: " + user + " " + "High Score: " + 0);
       
       try {
           java.io.PrintWriter output = new java.io.PrintWriter(file);
        
           // write formatted output to the file
           output.println(user + " " + highScore);
           output.close();
         } 
       catch (IOException ex)  {
           // do nothing at all
       } 
           
       // hide the login frame and show the main game frame
            loginFrame.show(false);
            home.show(true);
            
            JOptionPane.showMessageDialog(this, "Please note: your highscore " +
                    "will only be stored when you get a question wrong");
        } 
        
        // ------------------------- end login button code ------------------------- 
        
        // ------------------------- logout button code ------------------------- 
        
        else if (e.getSource() == logOut) {   // -------------------------- log out code
            
            String message = txtUsername.getText();
            scoreLabel.setText(message);
            
            try {
                java.io.File file = new java.io.File(user + ".txt");
                java.io.PrintWriter output = new java.io.PrintWriter(file);
                Scanner  input = new Scanner(file);
        
// write formatted output to the file
                
    // re-assign the score from the temp file          
    score = temp;
    
    // if the score is higher than the current score, 
    // update the current highScore in the user's file
    if (temp > highScore) {
        output.println(user + " " + score);
        output.close();
        } 
    
    // if not, keep the current highScore
    else {
        output.println(user + " " + highScore);
        output.close();
        }
            } catch (IOException ex){
                ex.printStackTrace();
            }  
        
            // show the login frame again, and hide the game frame
            loginFrame.show(true);
            home.show(false); 
            
            // remove the current highScore
            highScore = 0;
            
            // add sound
            InputStream music;
            try {
                music=new FileInputStream(new File("logoutSound.wav"));
                AudioStream audios=new AudioStream(music);
                AudioPlayer.player.start(audios);
            }
            catch(Exception ef){
                JOptionPane.showMessageDialog(null,ef.getLocalizedMessage());
            }  
        }
}
    
    // this section creates some re-usable code for the correct sound
    public void sound()  {
        InputStream music;
        try {
            music=new FileInputStream(new File("correctSound.wav"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception ef){
            JOptionPane.showMessageDialog(null,ef.getLocalizedMessage());
        } 
    }
    
    // ------------------------- logout button code -------------------------

 // ------------------------- end button code -------------------------
    } // end program!!
