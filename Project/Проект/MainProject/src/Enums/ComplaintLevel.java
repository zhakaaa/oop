package Enums;

public enum ComplaintLevel {
    low {
        public String toString() {
            return "Low level of complaint. Some things is not okay.";
        }
    },
    medium {
        public String toString() {
            return "Medium level of complaint. Many things is not okay.";
        }
    },
    high{
        public String toString() {
            return "High level of complaint. All things is not okay.";
        }
    }
}
