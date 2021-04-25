package by.ovsyanka.domain.train;

import by.ovsyanka.domain.user.TrainDriver;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
public class Locomotive extends Carriage {

    private TrainDriver trainDriver;

    public Locomotive(TrainDriver trainDriver) {
        checkNotNull(trainDriver);
        this.trainDriver = trainDriver;
    }

    public static Locomotive of(TrainDriver trainDriver) {
        return new Locomotive(trainDriver);
    }

    public void setTrainDriver(TrainDriver trainDriver) {
        checkNotNull(trainDriver);
        this.trainDriver = trainDriver;
    }
}
