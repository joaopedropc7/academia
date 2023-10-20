package com.academia.academia.repositories;

import com.academia.academia.models.ClientModel;
import com.academia.academia.models.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

    MatriculaModel findMatriculaModelById(Integer clientId);

}

