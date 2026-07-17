class WorkoutPlan {

    public static String getWorkoutPlan(Membership membership) {
        if (membership == null) {
            return "No membership assigned.\nPlease assign a membership to view a workout plan.";
        }

        if (membership instanceof BasicMembership) {
            return "Basic Membership Workout Plan\n\n" +
                   "Monday    - Chest + Triceps\n" +
                   "Tuesday   - Rest\n" +
                   "Wednesday - Back + Biceps\n" +
                   "Thursday  - Rest\n" +
                   "Friday    - Legs + Shoulders\n" +
                   "Saturday  - Light Cardio\n" +
                   "Sunday    - Rest";
        } else if (membership instanceof PremiumMembership) {
            return "Premium Membership Workout Plan\n\n" +
                   "Monday    - Chest + Triceps\n" +
                   "Tuesday   - Back + Biceps\n" +
                   "Wednesday - Legs\n" +
                   "Thursday  - Shoulders + Abs\n" +
                   "Friday    - Arms + Cardio\n" +
                   "Saturday  - Functional Training + Core\n" +
                   "Sunday    - Active Recovery";
        }

        return "Workout plan not available.";
    }
}