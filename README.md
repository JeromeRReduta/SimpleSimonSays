# WHAT

Recently I've been looking at Randy Ingermanson's [snowflake method](https://www.advancedfictionwriting.com/articles/snowflake-method/)
(I honestly don't remember why). Essentially, the snowflake method is a process for writing the first draft of your
fiction story, starting from the most general, 1-sentence summary of its plot and then going down higher and higher
levels of specificity until you can write out the whole first draft. As you get more and more specific,
you'll have a tighter understanding of the story as a whole.

I realized that there was a more general version of this process, one that lets you write more than fiction stories - you could apply this process
to ANY written process, including coding. After all, designing code is just finding a description for a sytsem
of software.

So for a coding version of the snowflake method, I've figured it would have the following steps:
1. One-sentence summary: what does this app do?
2. Expand one-sentence summary into paragraph. Each sentence details something the app does.
3. Write simple summary of components - each component is a class. Include the name and a one-sentence summary of what it is.
4. Expand each sentence in your one-paragraph summary into a full paragraph summary, including how each class
helps achieve the goal of the app.
5. Expand one-sentence class summaries into one paragraph class summaries, including what it does, dependencies, dependents
6. Expand multi-paragraph app summary into multi-section app summary.
7. Expand one-paragraph class summaries into pseudocode
8. Expand multi-section app summary into pseudocode
9. (OPTIONAL) Expand each piece of pseudocode for app into multi-section description of how the app works
10. Write the code

Part of the snowflake method is that these steps are LIVING DOCUMENTS - these documents aren't just things you write
once and then are done - these are 10 different ways to view one design, and if one part of the design changes then
all 10 levels of specificity should change to reflect that. In addition, it's expected that as you get more
specific and understand more of the project as a whole, you will go back to less specific levels and redesign
parts that you now realize were bad/sub-optimal decisions.

#What am I doing in this project?
First, I'm going to design a "simple" (i.e. bad) Simon Says project using the above process. Then I'll use
some basic Scrum/Agile methodology to program the project.

I'll be using Git as a changelog for this README, and write out each step of the summary, updating every section
as needed.

# 1: One sentence app summary

This app replicates a simple simon says game.

#2: One-par app summary
This app replicates a simple Simon Says game. It does this by displaying a panel with 4 colored buttons.
Then it decides on a randomly-generated sequence of colors that is MAX_ROUNDS steps long (let's say MAX_ROUNDS is 5 by default).
On round ROUND_NUM, it plays ROUND_NUM steps of that sequence by lighting up buttons of each color, and the user must replicate that sequence.
If they fail, the app displays frowny faces on the buttons and terminates. If they succeed, increment ROUND_NUM by 1, and repeat
the process. If the user wins on the final round (i.e. ROUND_NUM == MAX_ROUNDS), then the app displays happy faces
on the buttons and terminates.

# 3 Simple summary of components

1. DISPLAY shows the panels and buttons, i.e. handles hwo the app is displayed
2. PANELS are its own thing
3. LIGHT-CHANGING BUTTON is a button that can toggle whether it's lit or not, when given a command
4. GAMECONTROLLER handles logic for displaying the app, changing the buttons to light them up or not, tracks
the rounds, and ending the game (for win or loss), and generating the sequence.
5. COLOR_SEQUENCE is a sequence of colors
6. COLOR_SEQUENCE_GENERATOR generates a COLOR_SEQUENCE with given length
7. COLOR_SEQUENCE_CHECKER checks two color_sequences to be equal up to a given step
8. INPUT_READER converts the user's button inputs into a color sequence.
9. GAME DATA holds the info for: what round it is, what max_round is, what the randomly-generated color
sequence is, and whether the user has won or failed or is continuing

# 4 Multi-paragraph app summary, including components
This app replicates a simple Simon says game. First, the DISPLAY shows the user a PANEL with 4
LIGHT-CHANGING BUTTONS.

Then, the GAME CONTROLLER decides how long the game will go and sets that into GAME DATA. This can be done randomly,
with user input, or with the default number of 5.

After this, the GAME CONTROLLER tells the COLOR SEQUENCE GENERATOR to generate a random color sequence with
MAX_ROUNDS steps. It saves this sequence in GAME DATA. Given this sequence, the GAME CONTROLLER tells the LIGHT-CHANGING
BUTTONS to light up in the sequence matching the generated color sequence, up to ROUND_NUM steps.

The user tries to replicate the button sequence, and their inputs are converted to a color sequence by the
INPUT_READER. If the user succeeds, GAME_CONTROLLER increments ROUND_NUM and the process begins again. If they fail, the GAMECONTROLLER tells the 
DISPLAY to display frowny faces and GAMECONTROLLER terminates the program.

If the user succeeds on the final round, the GAMECONTROLLER tells the DISPLAY to display happy faces and
GAME CONTROLLER terminates the program.

# 5 Expand one-sentence class summaries into one paragraph class summaries, including what it does, dependencies, dependents
### DISPLAY

Uses: Panels, LightChangingButtons, Game Data

UsedBy: GameController

Handles logic for how the app is displayed. This includes how the panels and buttons are laid out, and
lighting a button on and off, and displaying a happy or frowny face.

### PANELS

Uses: N/A

Used By: Display

A JPanel display.

### LIGHT CHANGING BUTTONS

Uses: N/A

Used By: Display, Panel?

A button which changes lighting (can be done by changing color to lighter shade if needed) when requested,
and then immediately turns off. This should also be able to have text written on top of it.

### GAME DATA

Uses: ColorSequence

Used by: GameController, Display

Data for: max_rounds, round_num, and user state (i.e. PLAYING, WON, or LOST)

### GAME CONTROLLER

Uses: DISPLAY, GAME DATA, COLOR SEQUENCE GENERATOR

Used by: GAME APP

Handles all logic involving game data and display.


### COLOR SEQUENCE

Uses: N/A

Used by: ColorSequenceGenerator, ColorSequenceChecker, GameController, GameData

Functions as an ordered list of colors - could be represented as strings or colors or enums

### COLOR SEQUENCE GENERATOR

Uses: ColorSequence

Used by: GameController

Generates a ColorSequence with a given length. For our purposes, we want a random generator.


### COLOR SEQUENCE CHECKER

Uses: ColorSequence

Used by: GameController

Matches two ColorSequences for equal values up to a given length. Should function the same as checking
two ordered lists to see if all their values from index 0 to index some-integer are matching.

### INPUT READER

Uses: N/A

Used by: GameController

On a given round_num, reads the user's next round_num button clicks and converts them into a sequence
of colors. E.g. if the user hits the red and then blue button on round 2, the input reader returns a color
sequence of red -> blue.

### GAME APP

Uses: GameController, ColorSequenceGenerator, ColorSequence

Used by: N/A

Highest-level component. Creates the randomly-generated color sequence to be used in Game Data, and tells
the GameController to begin the game


# 6. Expand multi-paragraph app summary into multi-section app summary.

This app replicates a simple Simon says game. 

First, the GAME APP initializes all data required to run the game. It uses a COLOR SEQUENCE GENERATOR
to make a randomly-generated COLOR SEQUENCE, sets the number of rounds to play, and saves this data into 
GAME DATA.

Then it initializes the DISPLAY, with a JPANEL holding 4 LIGHT-CHANGING BUTTONS. Each LIGHT-CHANGING BUTTON is
a different color.

Then it initializes the GAME CONTROLLER, which will handle the game logic itself.

The GAME CONTROLLER tells the DISPLAY to light up the LIGHT-CHANGING BUTTON corresponding
to the first round_num steps in the sequence in GAME DATA. The user pushes round_num buttons. The INPUT READER converts the user's input
into a COLOR SEQUENCE. If the player's COLOR SEQUENCE matches GAME DATA'S COLOR SEQUENCE for the first n steps,
then the GAME CONTROLLER increments GAME DATA'S round_num by 1. If round_num > max_rounds, GAME CONTROLLER tells
the DISPLAY to display happy faces on the LIGHT-CHANGING BUTTONS and terminates. If the player's COLOR SEQUENCE does not match
with GAME DATA's for up to n steps, the GAME CONTROLLER tells the DISPLAY to display frowny faces on the 
LIGHT-CHANGING BUTTONS and terminates.

We begin at round 1.



