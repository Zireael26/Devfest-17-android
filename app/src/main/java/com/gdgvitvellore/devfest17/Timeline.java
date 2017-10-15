package com.gdgvitvellore.devfest17;

public enum Timeline {

    D11("DevFest 17’ will official kick off and coders, creators and innovators alike rejoice!" +
            " A brief speech followed by general introduction to the event outline, it's rules and" +
            " regulations."),
    D12("DevFest 17’ has an amazing lineup of speakers, with this being the first, you'll get a" +
            " taste of what's about to come. These people are exceptional at what they do and will" +
            " surely blow your mind."),
    D13("This is it! Main event begins… Get your thinking caps on! Ready. Set. Create. \n" +
            "This will mark the beginning of the core of our event. This would be a once in while" +
            " opportunity to network, create, collaborate and grow---all under the GDG Umbrella.\n"),
    D14("Time to give your brain a much needed snooze. Fill up your tummies and rejuvenate.\n" +
            "Eat, drink and reflect on all you've learnt already, what better way to do that with a" +
            " plate stocked with food and talk with people who inspire. Get ready for the marathon" +
            " that awaits you."),
    D21("The ideation ends. You should have your presentation ready. Snacks are served to recharge" +
            " y’all for the upcoming pitching session. The hackathon meanwhile, continues."),
    D22("Get ready for your pitches. A judging committee will review your work and presentation" +
            " for the idea you brainstormed on. The results and the names of the top teams will" +
            " be declared later in the day."),
    D23("If you want to go back to your rooms and catch a snooze in your comfy beds, now would be" +
            " the time to do it.\n"),
    D24("Don't let hunger get in the way of creating. Catch up on some meal time with your" +
            " breakfast giving you a break from coding."),
    D25("This would be to remind you of the looking deadline, and to finish up on integrating the" +
            " modules you have been working on. Add finishing touches to your project to make it" +
            " stand out."),
    D26("Time's up fellas! End the codes and start the presentations. You now have to finish" +
            " what you started and get working on a pitch to be presented to the judges." +
            " This would be the first call for pitch submission."),
    D27("Time to see what you and your friends did all those 18 hours. Adhere to the deadlines," +
            " the pitching would begin at 2 PM.\n"),
    D28("Get ready to have your curiosity prodded and long standing questions answered." +
            " You're in for a treat!"),
    D29("The results are announced for the winners of the Ideathon and Hackathon, everyone" +
            " collects their schwags and says goodbye to an exciting weekend.");

    private String displayName;

    Timeline(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
