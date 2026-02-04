class IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Default identity verification.");
    }
}

class HumanIdentity extends IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using human proctor.");
    }
}

class AIIdentity extends IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using AI system.");
    }
}

class BiometricIdentity extends IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Verifying identity using biometric scanner.");
    }
}

class EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Default environment check.");
    }
}

class HumanEnvironment extends EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Checking environment manually by human.");
    }
}

class AIEnvironment extends EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Checking environment using AI camera system.");
    }
}

class BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Default behaviour monitoring.");
    }
}

class HumanBehaviour extends BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Monitoring behaviour using human proctor.");
    }
}

class AIBehaviour extends BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Monitoring behaviour using AI system.");
    }
}

class ProctoringController {
    private IdentityVerification identityVerifier;
    private EnvironmentCheck environmentChecker;
    private BehaviourMonitoring behaviourMonitor;

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

public class problem2 {
    public static void main(String[] args) {
        IdentityVerification humanId = new HumanIdentity();
        ProctoringController exam1 = new ProctoringController(humanId, null, null);
        exam1.startExam();

        IdentityVerification aiId = new AIIdentity();
        EnvironmentCheck aiEnv = new AIEnvironment();
        BehaviourMonitoring aiBeh = new AIBehaviour();
        ProctoringController exam2 = new ProctoringController(aiId, aiEnv, aiBeh);
        exam2.startExam();

        IdentityVerification bioId = new BiometricIdentity();
        EnvironmentCheck humanEnv = new HumanEnvironment();
        BehaviourMonitoring aiBehaviour = new AIBehaviour();
        ProctoringController exam3 = new ProctoringController(bioId, humanEnv, aiBehaviour);
        exam3.startExam();
    }
}
