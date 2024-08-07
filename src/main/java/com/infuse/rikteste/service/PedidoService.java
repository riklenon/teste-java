package com.infuse.rikteste.service;

import com.infuse.rikteste.repository.ClienteRepository;
import com.infuse.rikteste.repository.PedidoRepository;
import com.infuse.rikteste.model.Cliente;
import com.infuse.rikteste.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido salvarPedido(Pedido pedido) {
        if (pedidoRepository.existsByNumeroControle(pedido.getNumeroControle())) {
            throw new IllegalArgumentException("Número de controle já cadastrado");
        }

        if (pedido.getDataCadastro() == null) {
            pedido.setDataCadastro(LocalDate.now());
        }

        if (pedido.getQuantidade() == null) {
            pedido.setQuantidade(1);
        }

        BigDecimal valorTotal = pedido.getValor().multiply(new BigDecimal(pedido.getQuantidade()));

        if (pedido.getQuantidade() > 5 && pedido.getQuantidade() < 10) {
            valorTotal = valorTotal.multiply(new BigDecimal("0.95"));
        } else if (pedido.getQuantidade() >= 10) {
            valorTotal = valorTotal.multiply(new BigDecimal("0.90"));
        }

        pedido.setValorTotal(valorTotal);

        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        pedido.setCliente(cliente);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarPedidos(String numeroPedido, LocalDate dataCadastro) {
        if (numeroPedido != null && dataCadastro != null) {
            return pedidoRepository.findByNumeroControleAndDataCadastro(numeroPedido, dataCadastro);
        } else if (numeroPedido != null) {
            return pedidoRepository.findByNumeroControle(numeroPedido);
        } else if (dataCadastro != null) {
            return pedidoRepository.findByDataCadastro(dataCadastro);
        } else {
            return pedidoRepository.findAll();
        }
    }
}
