package escape.required;

public class RuleImpl implements Rule {

    private RuleID ruleId;
    private int value;
    public RuleImpl(RuleID ruleid, int value ){
        this.ruleId = ruleid;
        this.value = value;
    }

    /**
     * @return the RuleID
     */
    @Override
    public RuleID getId() {
        return null;
    }

    /**
     * @return If this is a rule with a value (e.g. TURN_LIMIT), then this returns that value.
     * If it is has no value (e.g. REMOVE), return 0
     */
    @Override
    public int getIntValue() {
        return this.value;
    }
}
