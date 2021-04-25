package by.ovsyanka.domain.train;

import by.ovsyanka.domain.user.TrainDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Getter
public class Locomotive extends Carriage {

    private TrainDriver trainDriver;

    public Locomotive(TrainDriver trainDriver) {
        checkNotNull(trainDriver);
        this.trainDriver = trainDriver;

        log.info("Locomotive {} created". toString());
    }

    public static Locomotive of(TrainDriver trainDriver) {
        return new Locomotive(trainDriver);
    }

    public void setTrainDriver(TrainDriver trainDriver) {
        checkNotNull(trainDriver);
        this.trainDriver = trainDriver;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "trainDriver=" + trainDriver +
                '}';
    }
}
