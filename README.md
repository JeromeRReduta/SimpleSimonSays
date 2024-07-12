#WHAT

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

#1: One sentence app summary

This app replicates a simple simon says game.

#2: One-par app summary
This app replicates a simple Simon Says game. It does this by displaying a panel with 4 colored buttons.
Then it decides on a randomly-generated sequence of colors that is MAX_ROUNDS steps long (let's say MAX_ROUNDS is 5 by default).
On round ROUND_NUM, it plays ROUND_NUM steps of that sequence by lighting up buttons of each color, and the user must replicate that sequence.
If they fail, the app displays frowny faces on the buttons and terminates. If they succeed, increment ROUND_NUM by 1, and repeat
the process. If the user wins on the final round (i.e. ROUND_NUM == MAX_ROUNDS), then the app displays happy faces
on the buttons and terminates.

#3 Simple summary of components

1. DISPLAY shows the panels and buttons, i.e. handles hwo the app is displayed
2. PANELS are its own thing
3. LIGHT-CHANGING BUTTON is a button that can toggle whether it's lit or not, when given a command
4. GAMECONTROLLER handles logic for displaying the app, changing the buttons to light them up or not, tracks
the rounds, and ending the game (for win or loss), and generating the sequence.
5. ROUND_TRACKER keeps track of what round it is and what the max_round is
6. COLOR_SEQUENCE is a sequence of colors
7. RANDOM_COLOR_SEQUENCE_GENERATOR generates a random COLOR_SEQUENCE with given length
8. COLOR_SEQUENCE_CHECKER checks two color_sequences to be equal up to a given step
9. FACE_DISPLAYER makes buttons display happy or frowny faces based on command
10. INPUT_READER converts the user's button inputs into a color sequence.

#4 Multi-paragraph app summary, including components
This app replicates a simple Simon says game. First, the DISPLAY shows the user a PANEL with 4
LIGHT-CHANGING BUTTONS.

Then, the GAME CONTROLLER decides how long the game will go and sets that to MAX_ROUNDS. This can be done randomly,
with user input, or with the default number of 5.

After this, the GAME CONTROLLER tells the RANDOM COLOR SEQUENCE GENERATOR to generate a random color sequence with
MAX_ROUNDS steps. It saves this sequence in memory. Given this sequence, the GAME CONTROLLER tells the LIGHT-CHANGING
BUTTONS to light up in the sequence matching the generated color sequence, up to ROUND_NUM steps.

The user tries to replicate the button sequence, and their inputs are converted to a color sequence by the
INPUT_READER. If the user succeeds, ROUND_TRACKER increments itself and the process begins again. If they fail, the GAMECONTROLLER tells the
FACE_DISPLAYER to display frowny faces and GAMECONTROLLER terminates the program.

If the user succeeds on the final round, the GAMECONTROLLER tells the FACE DISPLAYER to display happy faces and
GAME CONTROLLER terminates the program.
