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