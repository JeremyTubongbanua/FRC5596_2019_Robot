package frc.robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

@SuppressWarnings("deprecation")
public class AutoSelector {
    public static SendableChooser<String> startPosition;
    public static SendableChooser<String> firstHatch;
    public static SendableChooser<String> secondHatch;

    //starting positions
    public static final String POS_LEFT = "Left";
    public static final String POS_RIGHT = "Right";

    public static final String CS_FRONT = "Front cargo ship";
    public static final String CS_SIDE1 = "Close cargo ship";
    public static final String CS_SIDE2 = "Middle cargo ship";
    public static final String CS_SIDE3 = "Far cargo ship";

    public static final String RS_CLOSE1 = "Close level 1 rocket";
    public static final String RS_CLOSE2 = "Close level 2 rocket";
    public static final String RS_CLOSE3 = "Close level 3 rocket";

    public static final String RS_FAR1 = "Far level 1 rocket";
    public static final String RS_FAR2 = "Far level 2 rocket";
    public static final String RS_FAR3 = "Far level 3 rocket";

    public static final String NONE = "nothing";

    private static String position;
    private static String firstAction;
    private static String secondAction;

    static {
        startPosition = new SendableChooser<>();
        firstHatch = new SendableChooser<>();
        secondHatch = new SendableChooser<>();

        //********************************************************************************** 
        // start position
        //**********************************************************************************
        startPosition.addDefault(POS_LEFT, POS_LEFT);
        startPosition.addObject(POS_RIGHT, POS_RIGHT);

        //********************************************************************************** 
        // first hatch
        //**********************************************************************************
        firstHatch.addDefault(NONE + " (First hatch)", NONE);
        firstHatch.addObject(CS_FRONT, CS_FRONT);
        firstHatch.addObject(CS_SIDE1, CS_SIDE1);
        firstHatch.addObject(CS_SIDE2, CS_SIDE2);
        firstHatch.addObject(CS_SIDE3, CS_SIDE3);

        firstHatch.addObject(RS_CLOSE1, RS_CLOSE1);
        firstHatch.addObject(RS_CLOSE2, RS_CLOSE2);
        firstHatch.addObject(RS_CLOSE2, RS_CLOSE2);

        firstHatch.addObject(RS_FAR1, RS_FAR1);
        firstHatch.addObject(RS_FAR2, RS_FAR2);
        firstHatch.addObject(RS_FAR3, RS_FAR3);

        //********************************************************************************** 
        // second hatch
        //**********************************************************************************
        secondHatch.addDefault(NONE + " (Second hatch)", NONE);
        secondHatch.addObject(CS_FRONT, CS_FRONT);
        secondHatch.addObject(CS_SIDE1, CS_SIDE1);
        secondHatch.addObject(CS_SIDE2, CS_SIDE2);
        secondHatch.addObject(CS_SIDE3, CS_SIDE3);

        secondHatch.addObject(RS_CLOSE1, RS_CLOSE1);
        secondHatch.addObject(RS_CLOSE2, RS_CLOSE2);
        secondHatch.addObject(RS_CLOSE2, RS_CLOSE2);

        secondHatch.addObject(RS_FAR1, RS_FAR1);
        secondHatch.addObject(RS_FAR2, RS_FAR2);
        secondHatch.addObject(RS_FAR3, RS_FAR3);

        //********************************************************************************** 
        // put on smartdashboard
        //**********************************************************************************
        
        position = startPosition.getSelected();
        firstAction = firstHatch.getSelected();
        secondAction = secondHatch.getSelected();
        //********************************************************************************** 
        // autonomous choice overrides
        //**********************************************************************************

        //the nothing autonomous
        if(firstAction == NONE){
            secondAction = NONE;
        }

        //find duplicates
        if(secondAction == firstAction){
            switch(secondAction){
                case CS_SIDE1:
                secondAction = CS_SIDE2;
                break; 

                case CS_SIDE2:
                secondAction = CS_SIDE3;
                break; 

                case CS_SIDE3:
                firstAction = CS_SIDE2;
                break; 

                case RS_CLOSE1:
                secondAction = RS_CLOSE2;
                break;

                case RS_CLOSE2:
                firstAction = RS_CLOSE1;
                break; 

                case RS_CLOSE3:
                firstAction = RS_CLOSE2;
                break;  
                
                case RS_FAR1:
                secondAction = RS_FAR2;
                break;  
                
                case RS_FAR2:
                firstAction = RS_FAR1;
                break;  
                
                case RS_FAR3:
                firstAction = RS_FAR2;
                break;

                default:
                firstAction = NONE;
                secondAction = NONE;
                break;
            }
        }
    }

    public static String getPosition(){
        return position;
    }

    public static String getFirstAction(){
        return firstAction;
    }

    public static String getSecondAction(){
        return secondAction;
    }
}