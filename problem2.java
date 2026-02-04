// ================== Interfaces ==================

interface IdentityVerification {
    void verifyIdentity();
}

interface EnvironmentCheck {
    void checkEnvironment();
}

interface BehaviourMonitoring {
    void monitorBehaviour();
}

// ================== Identity Verification Techniques ==================

class HumanIdentity implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using human proctor.");
    }
}

class AIIdentity implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using AI system.");
    }
}

class BiometricIdentity implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using biometric scanner.");
    }
}

// ================== Environment Check Techniques ==================

class HumanEnvironment implements EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Checking environment manually by human.");
    }
}

class AIEnvironment implements EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Checking environment using AI camera system.");
    }
}

// ================== Behaviour Monitoring Techniques ==================

class HumanBehaviour implements BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Monitoring behaviour using human proctor.");
    }
}

class AIBehaviour implements BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Monitoring behaviour using AI system.");
    }
}

// ================== Proctoring Controller ==================

class ProctoringController {
    private IdentityVerification identityVerifier;
    private EnvironmentCheck environmentChecker;
    private BehaviourMonitoring behaviourMonitor;

    // Constructor allows setting different techniques dynamically
    public ProctoringController(IdentityVerification id,
                                EnvironmentCheck env,
                                BehaviourMonitoring beh) {
        this.identityVerifier = id;
        this.environmentChecker = env;
        this.behaviourMonitor = beh;
    }

    public void startExam() {
        if(identityVerifier != null) identityVerifier.verifyIdentity();
        if(environmentChecker != null) environmentChecker.checkEnvironment();
        if(behaviourMonitor != null) behaviourMonitor.monitorBehaviour();
        System.out.println("Exam started successfully.\n");
    }
}

// ================== Main ==================

public class OnlineProctoring {
    public static void main(String[] args) {

        // Example 1: Simple exam - only identity verification
        IdentityVerification humanId = new HumanIdentity();
        ProctoringController exam1 = new ProctoringController(humanId, null, null);
        exam1.startExam();

        // Example 2: Full exam with AI-based monitoring
        IdentityVerification aiId = new AIIdentity();
        EnvironmentCheck aiEnv = new AIEnvironment();
        BehaviourMonitoring aiBeh = new AIBehaviour();
        ProctoringController exam2 = new ProctoringController(aiId, aiEnv, aiBeh);
        exam2.startExam();

        // Example 3: Mixed techniques
        IdentityVerification bioId = new BiometricIdentity();
        EnvironmentCheck humanEnv = new HumanEnvironment();
        BehaviourMonitoring aiBehaviour = new AIBehaviour();
        ProctoringController exam3 = new ProctoringController(bioId, humanEnv, aiBehaviour);
        exam3.startExam();
    }
}
