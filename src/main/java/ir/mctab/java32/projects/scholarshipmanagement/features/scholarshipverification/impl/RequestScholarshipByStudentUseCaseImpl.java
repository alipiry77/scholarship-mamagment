package ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl;

import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.Service;
import ir.mctab.java32.projects.scholarshipmanagement.core.annotations.UseCase;
import ir.mctab.java32.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.RequestScholarshipByStudentUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.model.Scholarship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class RequestScholarshipByStudentUseCaseImpl implements RequestScholarshipByStudentUseCase {
    public void request(Scholarship scholarships) {
        Connection connection = null;
        try {
            connection = DatabaseConfig.getDatabaseConnection();
            String sql = "INSERT INTO scholarship (status , name , family , nationalCode , " +
                    "lastUni , lastDegree , lastField , lastScore , applyUni , applyDegree , " +
                    "applyField , applyDate )"
                    +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,scholarships.getStatus());
            preparedStatement.setString(2,scholarships.getName());
            preparedStatement.setString(3,scholarships.getFamily());
            preparedStatement.setString(4,scholarships.getNationalCode());
            preparedStatement.setString(5,scholarships.getLastUni());
            preparedStatement.setString(6,scholarships.getLastDegree());
            preparedStatement.setString(7,scholarships.getLastField());
            preparedStatement.setFloat(8,scholarships.getLastScore());
            preparedStatement.setString(9,scholarships.getApplyUni());
            preparedStatement.setString(10,scholarships.getApplyDegree());
            preparedStatement.setString(11,scholarships.getApplyField());
            preparedStatement.setString(12,scholarships.getApplyDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
