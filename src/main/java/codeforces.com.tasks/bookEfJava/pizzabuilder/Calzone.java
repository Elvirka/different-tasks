package codeforces.com.tasks.bookEfJava.pizzabuilder;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }
        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public boolean getSauceLocation(){
        return sauceInside;
    }
}