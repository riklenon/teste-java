package com.infuse.rikteste.controller;

import com.infuse.rikteste.model.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import com.infuse.rikteste.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(summary = "Cria um novo pedido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados incompatíveis")
    })
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Recupera lista de pedidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de pedidos recuperada"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Pedido>> buscarPedidos(
        @RequestParam(required = false) String numeroPedido,
        @RequestParam(required = false) LocalDate dataCadastro) {

        List<Pedido> pedidos = pedidoService.buscarPedidos(numeroPedido, dataCadastro);
        return ResponseEntity.ok(pedidos);
    }
}
