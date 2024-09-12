package com.eng.planeng.service;

import com.eng.planeng.dto.client.ClientRequestDTO;
import com.eng.planeng.dto.client.ClientResponseDTO;
import com.eng.planeng.entity.client.Client;
import com.eng.planeng.exception.ResourceNotFoundException;
import com.eng.planeng.repository.ClientRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClientResponseDTO> findAll() {
        List<Client> clients = repository.findAll();
        return clients.stream().map(this::convertToDTO).toList();
    }

    public ClientResponseDTO findById(Long id) {
        Optional<Client> client = repository.findById(id);
        return convertToDTO(client.orElseThrow(() -> new ResourceNotFoundException("Client not found! Id " + id + ".")));
    }

    public ClientResponseDTO insert(ClientRequestDTO clientDTO) {
        Client client = repository.save(convertToEntity(clientDTO));
        return convertToDTO(client);
    }

    public ClientResponseDTO update(Long id, ClientRequestDTO clientDTO) {
        Optional<Client> client = repository.findById(id);
        if (client.isEmpty()) {
            throw new ResourceNotFoundException("Client not found! Id " + id + ".");
        }
        updateData(client.get(), clientDTO);
        return convertToDTO(repository.save(client.get()));
    }

    private void updateData(Client client, ClientRequestDTO clientDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(clientDTO, client);
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Client not found! Id " + id + ".");
        }
    }

    public Client convertToEntity(ClientRequestDTO dto) {
        return modelMapper.map(dto, Client.class);
    }

    public ClientResponseDTO convertToDTO(Client entity) {
        return modelMapper.map(entity, ClientResponseDTO.class);
    }
}
